// type anal extends handle

funcdef unit UnitAlive(unit u);

hashtable HT = InitHashtable();
bool s1 = "a" != "";
bool s2 = "" == "a";
bool s3 = "" == LoadStr(HT, 0, 0);
bool b1 = 1 == null;
array<int> a;
float b = 33.3;
int hex = $A;
int hex1 = 0xA;
int raw = 'A';
string s = "a" + "b";

void Ba() {
}
float A(float a, CallbackFunc d) {
	TimerStart(15., true, Ba);
	s[0] = "00";
	s[1] = "11";
	if (a > b) {
		s = s + "e";
	}
	while (true) {
		s = s + "g";
		if (b > a) break;
	}
	UnitAlive(null);
	return a * b;
}