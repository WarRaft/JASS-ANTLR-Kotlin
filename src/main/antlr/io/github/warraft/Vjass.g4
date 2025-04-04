grammar Vjass;

root : (library | rootItem)* EOF ;

rootItem : nativeRule | globals | function | library;

library : (LIBRARY|SCOPE) ID (INITIALIZER ID)? ((REQUIRES|NEEDS|USES) ID (COMMA ID)*)? rootItem* (ENDLIBRARY|ENDSCOPE);

typename : ID;
varname : ID;

globals : GLOBALS stmt* ENDGLOBALS;

// === FUNCTION

param : typename varname ;
takes : TAKES (NOTHING|(param (COMMA param)*));
returnsRule : RETURNS (NOTHING|ID);

nativeRule : CONSTANT? NATIVE ID takes returnsRule;
function : (PUBLIC|PRIVATE)? CONSTANT? FUNCTION ID takes returnsRule stmt* ENDFUNCTION;

// === STATEMENT
left
    : ID #leftId
    | ID left #leftType
    | left COMMA left #leftComma
    | left LPAREN (expr (COMMA expr)*)? RPAREN #leftCall
    | left LBRACK expr? RBRACK #leftArr
    | left DOT left #leftDot
    ;

stmt
    : (SET|CALL)* left ((EQ|ADD_EQ|SUB_EQ|MUL_EQ|DIV_EQ) expr)? #stmtLeft
    | RETURN expr? #stmtReturn
    | IF expr THEN stmt* elseif* elseRule? ENDIF #stmtIf
    | LOOP stmt* ENDLOOP #stmtLoop
    | EXITWHEN expr #stmtExitWhen
    | LOCAL? typename ARRAY? varname brackExpr* (EQ expr)? #stmtVar
    | (DEBUG|STATIC|CONSTANT|PUBLIC|PRIVATE)+ stmt #stmtMod
    ;

brackExpr : LBRACK expr? RBRACK ;
elseif : ELSEIF expr THEN stmt*;
elseRule : ELSE stmt*;

// === EXPRESSION
expr
    : expr DOT expr #exprDot
    | LPAREN expr RPAREN # exprParen // 1
    | (SUB|NOT) expr # exprUn // 2
    | expr (MUL|DIV) expr # exprMul  // 3
    | expr (SUB|ADD) expr # exprAdd // 4
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
ENDSCOPE: 'endscope';
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
SCOPE : 'scope';
STATIC : 'static';
TAKES : 'takes';
THEN : 'then';
TRUE : 'true';
TYPE : 'type';
USES: 'uses';

DOT : '.';
COMMA : ',';

EQ_EQ: '==';
NEQ : '!=';
EQ : '=';
ADD_EQ : '+=';
SUB_EQ : '-=';
MUL_EQ : '*=';
DIV_EQ : '/=';

LT_EQ : '<=';
LT : '<';
GT_EQ: '>=';
GT : '>';

ADD : '+';
SUB : '-';
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
