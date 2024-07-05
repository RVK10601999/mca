int a = 0; int b = 0;

void setup()
{
	Serial.begin(9600); pinMode(13, OUTPUT);
}
void loop()
{
	a=analogRead(A0);
	b=map (a,0,1023,0,255);
	Serial.println(b);
	if (b>100)
	{
		Serial.println("Motion detected"); delay(100);
	}
}
