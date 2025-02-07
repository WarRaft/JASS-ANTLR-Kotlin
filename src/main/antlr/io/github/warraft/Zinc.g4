grammar Zinc;

root : rootItem* EOF ;
rootItem : lib | vis | stmt | function;

lib : (LIBRARY|STRUCT) ID (REQUIRES ID (COMMA ID)*)? LBRACE rootItem* RBRACE;

vis : (PUBLIC|PRIVATE) (rootItem|(LBRACE rootItem* RBRACE));

typename : ID;
varname : ID;

// === function
param : typename varname ;

function :
    (STATIC | CONSTANT)*
    (NATIVE|FUNCTION|METHOD)
    ID
    LPAREN (param (COMMA param)*)? RPAREN
    (RETURNS ID)?
    (stmt | LBRACE stmt* RBRACE)
    ;

// === STATEMENT
stmt
    :  (STATIC | CONSTANT)* typename varname brackExpr* (EQ expr)? SEMI #stmtVar
    | DEBUG? ID LPAREN (expr (COMMA expr)*)? RPAREN #stmtCall
    | RETURN expr? SEMI #stmtReturn
    | IF expr THEN stmt* elseif* elseRule? ENDIF #stmtIf
    | LOOP stmt* ENDLOOP #stmtLoop
    | EXITWHEN expr SEMI #stmtExitWhen
    ;

brackExpr : LBRACK expr? RBRACK ;
elseif : ELSEIF expr THEN stmt*;
elseRule : ELSE stmt*;

// === EXPRESSION
expr
    : LPAREN expr RPAREN # exprParen // 1
    | (MINUS|NOT) expr # exprUn // 2
    | expr (MUL|DIV) expr # exprMul  // 3
    | expr (MINUS|PLUS) expr # exprAdd // 4
    | expr (LT|LT_EQ|GT|GT_EQ) expr # exprLt
    | expr (EQ_EQ|NEQ) expr # exprEq
    | expr (AND_AND|OR_OR) expr # exprAnd
    | NULL # exprNull
    | (TRUE|FALSE) # exprBool
    | (INTVAL|HEXVAL|RAWVAL) # exprInt
    | REALVAL # exprReal
    | STRING # exprStr
    | ID LBRACK expr? RBRACK # exprArr
    | ID LPAREN (expr (COMMA expr)*)? RPAREN # exprCall
    | FUNCTION ID # exprFun
    | ID # exprVar
    ;

RAWVAL: '\'' (~['])* '\'';

STRING : '"' (STRING_ESC | STRING_CLOSE)* '"' ;
fragment STRING_ESC : '\\' . ;
fragment STRING_CLOSE : ~["\\] ;

CONSTANT : 'constant';
DEBUG : 'debug';
ELSE : 'else';
ELSEIF : 'elseif';
ENDIF : 'endif';
ENDLOOP : 'endloop';
ENDGLOBALS : 'endglobals';
ENDLIBRARY: 'endlibrary';
EXTENDS : 'extends';
EXITWHEN : 'exitwhen';
FALSE : 'false';
FUNCTION : 'function';
GLOBALS : 'globals';
IF : 'if';
LIBRARY : 'library';
LOOP : 'loop';
METHOD : 'method';
NATIVE : 'native';
NULL : 'null';
PUBLIC : 'public';
PRIVATE : 'private';
REQUIRES: 'requires';
RETURN : 'return';
STATIC: 'static';
STRUCT : 'struct';
TAKES : 'takes';
THEN : 'then';
TRUE : 'true';
TYPE : 'type';


RETURNS : '->';
NOT : '!';

DOT : '.';

COMMA : ',';
EQ_EQ: '==';
EQ : '=';
NEQ : '!=';
LT_EQ : '<=';

LT : '<';
GT_EQ: '>=';
GT : '>';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
AND_AND : '&&';
OR_OR : '||';

LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';
LBRACE : '{';
RBRACE : '}';
SEMI : ';';

ID : [A-Za-z_][_0-9A-Za-z]*;

fragment HexDigit: [0-9a-fA-F];

INTVAL: ('0' .. '9')+;
HEXVAL: (('0' [xX])| '$' )  HexDigit+;

REALVAL : (('0' .. '9')* '.' ('0' .. '9')+)|(('0' .. '9')+ '.' ('0' .. '9')*);

WS: [ \t]+ -> skip;
NL: [\r\n] -> skip;

COMMENT : '/*' (COMMENT|.)*? '*/' -> channel(2) ;
LINE_COMMENT: '//' ~[\r\n]* -> channel(2);

