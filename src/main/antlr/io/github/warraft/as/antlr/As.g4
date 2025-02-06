grammar As;

root: EOF;

/*
script
    : (
        import_
        | enum_
        | typdef
        | class_
        | mixin_
        | interface_
        | funcdef
        | virtprop
        | var_
        | func_
        | namespace
        | ';'
    )+ EOF
    ;

class_
    : ('shared' | 'abstract' | 'final' | 'external')* 'class' IDENTIFIER (
        ';'
        | (':' IDENTIFIER (',' IDENTIFIER)*)? '{' (virtprop | func_ | var_ | funcdef)* '}'
    )
    ;

typdef
    : 'typedef' PRIMTYPE IDENTIFIER ';'
    ;

namespace
    : 'namespace' IDENTIFIER '{' script '}'
    ;

func_
    : ('shared' | 'external')* ('private' | 'protected')? (type_ '&'? | '~')? IDENTIFIER paramlist 'const'? FUNCATTR? (
        ';'
        | statblock
    )
    ;

interface_
    : ('external' | 'shared')* 'interface' IDENTIFIER (
        ';'
        | (':' IDENTIFIER (',' IDENTIFIER)*)? '{' (virtprop | intfmthd)* '}'
    )
    ;

var_
    : ('private' | 'protected')? type_ IDENTIFIER ('=' (initlist | expr) | arglist)? (
        ',' IDENTIFIER ('=' (initlist | expr) | arglist)?
    )* ';'
    ;

import_
    : 'import' type_ '&'? IDENTIFIER paramlist FUNCATTR 'from' STRING ';'
    ;

enum_
    : ('shared' | 'external')* 'enum' IDENTIFIER (
        ';'
        | '{' IDENTIFIER ('=' expr)? (',' IDENTIFIER ('=' expr)?)* '}'
    )
    ;

funcdef
    : ('external' | 'shared')* 'funcdef' type_ '&'? IDENTIFIER paramlist ';'
    ;

virtprop
    : ('private' | 'protected')? type_ '&'? IDENTIFIER '{' (
        ('get' | 'set') 'const'? FUNCATTR (statblock | ';')
    )* '}'
    ;

mixin_
    : 'mixin' class_
    ;

intfmthd
    : type_ '&'? IDENTIFIER paramlist 'const'? ';'
    ;

statblock
    : '{' (var_ | statement)* '}'
    ;

paramlist
    : '(' (
        VOID
        | type_ typemod IDENTIFIER? ('=' expr)? (',' type_ typemod IDENTIFIER? ('=' expr)?)*
    )? ')'
    ;

typemod
    : ('&' ('in' | 'out' | 'inout')?)?
    ;

type_
    : 'const'? scope datatype ('<' type_ (',' type_)* '>')* ('[' ']' | '@' 'const'?)*
    ;

initlist
    : '{' (assign | initlist)? (',' (assign | initlist)?)* '}'
    ;

scope
    : '::'? (IDENTIFIER '::')* (IDENTIFIER ('<' type_ (',' type_)* '>')? '::')?
    ;

datatype
    : IDENTIFIER
    | PRIMTYPE
    | '?'
    | 'auto'
    ;

statement
    : if_
    | for_
    | while_
    | return_
    | statblock
    | break_
    | continue_
    | dowhile
    | switch_
    | exprstat
    | try_
    ;

switch_
    : 'switch' '(' assign ')' '{' case_* '}'
    ;

break_
    : 'break' ';'
    ;

for_
    : 'for' '(' (var_ | exprstat) exprstat (assign (',' assign)*)? ')' statement
    ;

while_
    : 'while' '(' assign ')' statement
    ;

dowhile
    : 'do' statement 'while' '(' assign ')' ';'
    ;

if_
    : 'if' '(' assign ')' statement ('else' statement)?
    ;

continue_
    : 'continue' ';'
    ;

exprstat
    : assign? ';'
    ;

try_
    : 'try' statblock 'catch' statblock
    ;

return_
    : 'return' assign? ';'
    ;

case_
    : ('case' expr | 'default') ':' statement*
    ;

expr
    : exprterm (exprop exprterm)*
    ;

exprterm
    : (type_ '=')? initlist
    | EXPRPREOP* exprvalue exprpostop*
    ;

exprvalue
    : VOID
    | constructcall
    | funccall
    | varaccess
    | cast
    | LITERAL
    | '(' assign ')'
    | lambda_
    ;

constructcall
    : type_ arglist
    ;

exprpostop
    : '.' (funccall | IDENTIFIER)
    | '[' (IDENTIFIER ':')? assign (',' IDENTIFIER? ':' assign)* ']'
    | arglist
    | '++'
    | '--'
    ;

cast
    : 'cast' '<' type_ '>' '(' assign ')'
    ;

lambda_
    : 'function' '(' ((type_ typemod)? IDENTIFIER (',' (type_ typemod)? IDENTIFIER)*)? ')' statblock
    ;

funccall
    : scope IDENTIFIER arglist
    ;

varaccess
    : scope IDENTIFIER
    ;

arglist
    : '(' (IDENTIFIER ':')? assign (',' (IDENTIFIER ':')? assign)* ')'
    ;

assign
    : condition (ASSIGNOP assign)?
    ;

condition
    : expr ('?' assign ':' assign)?
    ;

exprop
    : MATHOP
    | COMPOP
    | LOGICOP
    | BITOP
    ;

BITOP
    : '&'
    | '|'
    | '^'
    | '<<'
    | '>>'
    | '>>>'
    ;

MATHOP
    : PLUS
    | MINUS
    | '*'
    | '/'
    | '\''
    | '**'
    ;

COMPOP
    : '=='
    | '!='
    | '<'
    | '<='
    | '>'
    | '>='
    | 'is'
    | '!is'
    ;

LOGICOP
    : '&&'
    | '||'
    | '^^'
    | 'and'
    | 'or'
    | 'xor'
    ;

ASSIGNOP
    : '='
    | '+='
    | '-='
    | '*='
    | '/='
    | '|='
    | '&='
    | '^='
    | '%='
    | '**='
    | '<<='
    | '>>='
    | '>>>='
    ;

PRIMTYPE
    : VOID
    | 'int'
    | 'int8'
    | 'int16'
    | 'int32'
    | 'int64'
    | 'uint'
    | 'uint8'
    | 'uint16'
    | 'uint32'
    | 'uint64'
    | 'float'
    | 'double'
    | 'bool'
    ;

FUNCATTR
    : 'override'
    | 'final'
    | 'explicit'
    | 'property'
    ;

EXPRPREOP
    : MINUS
    | PLUS
    | '!'
    | '++'
    | '--'
    | '~'
    | '@'
    ;

VOID
    : 'void'
    ;

fragment PLUS
    : '+'
    ;

fragment MINUS
    : '-'
    ;

LITERAL
    : NUMBER
    | STRING
    | BITS
    | 'true'
    | 'false'
    | 'null'
    ;

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

NUMBER
    : [0-9] '.' [0-9]+
    ;

STRING
    : '"' ~ '"'* '"'
    | '\'' ~ '\''* '\''
    ;

BITS
    : ('0b' | '0o' | '0d' | '0x' | '0B' | '0O' | '0D' | '0X') [0-9a-z]
    ;

COMMENT
    : '//' ~ [\r\n]* -> skip
    ;

WS
    : [ \r\n\t]+ -> skip
    ;

*/
