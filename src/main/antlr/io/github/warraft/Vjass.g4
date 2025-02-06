grammar Vjass;

root : (type | nativeRule | globals | function)* EOF ;

typename : ID;
varname : ID;

// === type
type : TYPE ID extendsRule;
extendsRule : EXTENDS ID;

// === globals
globals : GLOBALS variable* ENDGLOBALS;

// === var
variable : CONSTANT? LOCAL? typename ARRAY? varname (EQ expr)?;

// === function
param : typename varname ;
params : param (COMMA param)* ;

takes : TAKES (NOTHING|params);
returnsRule : RETURNS (NOTHING|ID);

nativeRule : CONSTANT? NATIVE ID takes returnsRule;
function : CONSTANT? FUNCTION ID takes returnsRule variable* stmt* ENDFUNCTION ;

// === STATEMENT
stmt
    : set #stmtSet
    | call #stmtCall
    | returnRule #stmtReturn
    | ifRule #stmtIf
    | loop #stmtLoop
    | exitwhen #stmtExitWhen
    ;

setBrack : LBRACK expr? RBRACK ;
set : SET ID setBrack? EQ expr;

call : DEBUG? CALL ID LPAREN (expr (COMMA expr)*)? RPAREN;

returnRule : RETURN expr?;

ifRule : IF expr THEN stmt* elseif* elseRule? ENDIF;
elseif : ELSEIF expr THEN stmt*;
elseRule : ELSE stmt*;

loop : LOOP stmt* ENDLOOP ;
exitwhen : EXITWHEN expr ;

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
EXTENDS : 'extends';
EXITWHEN : 'exitwhen';
FALSE : 'false';
FUNCTION : 'function';
GLOBALS : 'globals';
IF : 'if';
LOCAL : 'local';
LOOP : 'loop';
NATIVE : 'native';
NOT : 'not';
NOTHING : 'nothing';
NULL : 'null';
OR : 'or';
RETURNS : 'returns';
RETURN : 'return';
SET : 'set';
TAKES : 'takes';
THEN : 'then';
TRUE : 'true';
TYPE : 'type';
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

LINE_COMMENT: '//' ~[\r\n]* -> channel(2);
