int cm = 0;
long readUltrasonicDistance(int triggerPin, int echoPin)
{
	pinMode(triggerPin, OUTPUT); // Clear the trigger 
	digitalWrite(triggerPin, LOW);
	delayMicroseconds(2);
	digitalWrite(triggerPin, HIGH);
	delayMicroseconds(10);
	digitalWrite(triggerPin, LOW);
	pinMode(echoPin, INPUT);
	return pulseIn(echoPin, HIGH);
}

void setup()
{
	pinMode(11, OUTPUT);
}

void loop()
{
	cm = 0.01723 * readUltrasonicDistance(7, 7);
	if (cm < 50) {
		digitalWrite(11, HIGH);
	} else {
		digitalWrite(11, LOW);
	}
	delay(100);
}
 
