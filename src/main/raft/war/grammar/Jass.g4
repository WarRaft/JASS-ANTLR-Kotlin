// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar  Jass ;

// https://github.com/antlr/grammars-v4
// https://github.com/antlr/antlr4/blob/master/doc/options.md

root : (type | native | globals | function)* EOF ;

typename : ID;
varname : ID;
funname : ID;

// === type
type : TYPE typename extends;
extends : EXTENDS typename;

// === globals
globals : GLOBALS variable* ENDGLOBALS;

// === var
variable : CONSTANT? LOCAL? typename ARRAY? varname (EQ expr)?;

// === function
param : typename varname;
params : param (COMMA param)*  ;

takes : TAKES (NOTHING|params);
returns_ : RETURNS (NOTHING|typename);

native : CONSTANT? NATIVE funname takes returns_;
function : CONSTANT? FUNCTION funname takes returns_ variable* stmt* ENDFUNCTION ;

// === STATEMENT
stmt
    : set
    | call
    | return
    | if
    | loop
    | exitwhen
    ;

set : SET varname (LBRACK expr? RBRACK)? EQ expr;

call : DEBUG? CALL funname LPAREN (expr (COMMA expr)*)? RPAREN;

return : RETURN expr?;

if : IF expr THEN? (stmt|elseif|else)* ENDIF;
elseif : ELSEIF expr THEN? stmt*;
else : ELSE stmt*;

loop : LOOP stmt* ENDLOOP ;
exitwhen : EXITWHEN expr ;

// === EXPRESSION
expr
    : LPAREN expr RPAREN # exprParen // 1
    | (MINUS|NOT) expr # exprUn // 2
    | expr (MUL|DIV) expr # exprMul  // 3
    | expr (MINUS|PLUS) expr # exprAdd // 4
    | expr EQ_EQ expr # exprEq
    | expr NEQ expr # exprNeq
    | expr LT expr # exprLt
    | expr LT_EQ expr # exprLtEq
    | expr GT expr # exprGt
    | expr GT_EQ expr # exprGtEq
    | expr OR expr # exprOr
    | expr AND expr # exprAnd
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

WS: [ \t]+ -> channel(HIDDEN);
NL: [\r\n] -> channel(2);

LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
