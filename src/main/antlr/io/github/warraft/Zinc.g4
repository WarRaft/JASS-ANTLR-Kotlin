grammar Zinc;

root : rootItem* EOF ;
rootItem : lib | vis | stmt | function;

lib : (LIBRARY|STRUCT) (LBRACK expr RBRACK)*  ID (REQUIRES ID (COMMA ID)*)? LBRACE rootItem* RBRACE;

vis : (PUBLIC|PRIVATE) (rootItem|(LBRACE rootItem* RBRACE));

typename : ID;
varname : ID;

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

left
    : ID #leftId
    | ID left #leftType
    | left LPAREN (expr (COMMA expr)*)? RPAREN #leftCall
    | left LBRACK left? RBRACK #leftArr
    | left DOT left #leftDot
    ;


stmt
    : (DEBUG| STATIC | CONSTANT)* left (EQ expr)? SEMI #stmtLeft
    | RETURN expr? SEMI #stmtReturn
    | (IF|WHILE|FOR) LPAREN expr RPAREN (stmt | (LBRACE stmt* RBRACE)) elseRule? #stmtIf
    ;

elseRule : ELSE (stmt | (LBRACE stmt* RBRACE));

// === EXPRESSION
expr
    : expr DOT expr #exprDot
    | LPAREN expr RPAREN # exprParen // 1
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
    | expr LBRACK expr? RBRACK # exprArr
    | expr LPAREN (expr (COMMA expr)*)? RPAREN # exprCall
    | FUNCTION ID # exprFun
    | FUNCTION LPAREN RPAREN (RETURNS ID)? LBRACE stmt* RBRACE # exprLambda
    | ID # exprVar
    ;

RAWVAL: '\'' (~['])* '\'';

STRING : '"' (STRING_ESC | STRING_CLOSE)* '"' ;
fragment STRING_ESC : '\\' . ;
fragment STRING_CLOSE : ~["\\] ;

CONSTANT : 'constant';
DEBUG : 'debug';
ELSE : 'else';
FALSE : 'false';
FOR : 'for';
FUNCTION : 'function';
IF : 'if';
LIBRARY : 'library';
METHOD : 'method';
NATIVE : 'native';
NULL : 'null';
PUBLIC : 'public';
PRIVATE : 'private';
REQUIRES: 'requires';
RETURN : 'return';
STATIC: 'static';
STRUCT : 'struct';
TRUE : 'true';
WHILE : 'while';

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

