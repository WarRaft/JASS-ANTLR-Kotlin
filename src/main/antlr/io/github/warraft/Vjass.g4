grammar Vjass;

root : (library | rootItem)* EOF ;

library : LIBRARY ID (INITIALIZER ID)? ((REQUIRES|NEEDS|USES) ID (COMMA ID)*)? rootItem* ENDLIBRARY;

rootItem : nativeRule | globals | function;

typename : ID;
varname : ID;

// === globals
globals : GLOBALS stmt* ENDGLOBALS;

// === function
param : typename varname ;
params : param (COMMA param)* ;

takes : TAKES (NOTHING|params);
returnsRule : RETURNS (NOTHING|ID);

nativeRule : CONSTANT? NATIVE ID takes returnsRule;
function : (PUBLIC|PRIVATE)? CONSTANT? FUNCTION ID takes returnsRule stmt* ENDFUNCTION;

// === STATEMENT
stmt
    : SET ID brackExpr? EQ expr #stmtSet
    | DEBUG? CALL ID LPAREN (expr (COMMA expr)*)? RPAREN #stmtCall
    | RETURN expr? #stmtReturn
    | IF expr THEN stmt* elseif* elseRule? ENDIF #stmtIf
    | LOOP stmt* ENDLOOP #stmtLoop
    | EXITWHEN expr #stmtExitWhen
    | (PUBLIC|PRIVATE)? CONSTANT? LOCAL? typename ARRAY? varname brackExpr* (EQ expr)? #stmtVar
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
    | expr (AND|OR) expr # exprAnd
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

AND : 'and';
ARRAY : 'array';
CALL : 'call';
CONSTANT : 'constant';
DEBUG : 'debug';
ELSE : 'else';
ELSEIF : 'elseif';
ENDFUNCTION : 'endfunction';
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
INITIALIZER : 'initializer';
LIBRARY : 'library';
LOCAL : 'local';
LOOP : 'loop';
NATIVE : 'native';
NEEDS: 'needs';
NOT : 'not';
NOTHING : 'nothing';
NULL : 'null';
OR : 'or';
PUBLIC : 'public';
PRIVATE : 'private';
REQUIRES: 'requires';
RETURNS : 'returns';
RETURN : 'return';
SET : 'set';
TAKES : 'takes';
THEN : 'then';
TRUE : 'true';
TYPE : 'type';
USES: 'uses';
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
LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';

ID : [A-Za-z_][_0-9A-Za-z]*;

fragment HexDigit: [0-9a-fA-F];

INTVAL: ('0' .. '9')+;
HEXVAL: (('0' [xX])| '$' )  HexDigit+;

REALVAL : (('0' .. '9')* '.' ('0' .. '9')+)|(('0' .. '9')+ '.' ('0' .. '9')*);

WS: [ \t]+ -> skip;
NL: [\r\n] -> skip;

COMMENT : '/*' (COMMENT|.)*? '*/' -> channel(2) ;
LINE_COMMENT: '//' ~[\r\n]* -> channel(2);
