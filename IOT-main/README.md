#EX1
##Variable Declaration:
int LED = 13;
Declares a variable named LED and assigns it the value 13, referring to the pin number on the Arduino board to which the LED is connected.

##setup() Function:
void setup() { pinMode(LED, OUTPUT); }
Runs once when the Arduino is powered on or reset.
Configures pin 13 as an output pin, meaning the Arduino can send voltage to this pin to control the LED.
##loop() Function:
void loop() { digitalWrite(LED, HIGH); delay(1000); digitalWrite(LED, LOW); delay(1000); }
Runs repeatedly after setup() finishes. It contains the main logic of the program.
##digitalWrite(LED, HIGH);
Sets pin 13 to a HIGH state, sending voltage to the LED, turning it on.
##delay(1000);
Pauses the program for 1000 milliseconds (1 second).
##digitalWrite(LED, LOW);
Sets pin 13 to a LOW state, stopping the voltage to the LED, turning it off.
##delay(1000);
Pauses the program for 1000 milliseconds (1 second).
##Summary:
The program turns the LED on for 1 second and then off for 1 second, repeating this cycle indefinitely. This results in the LED blinking on and off with a 1-second interval.

#EX2
##Variable Declaration:
int outputpin = A0;
Declares a variable named outputpin and assigns it the value A0, referring to the analog pin A0 on the Arduino board.
##setup() Function:
void setup() { Serial.begin(9600); }
Runs once when the Arduino is powered on or reset.
Initializes serial communication at a baud rate of 9600 bits per second, allowing the Arduino to send data to the computer.
##loop() Function:
void loop() { int analogValue = analogRead(outputpin); float millivolts = (analogValue / 1024.0) * 3300; float celsius = millivolts / 10; Serial.print("in DegreeC= "); Serial.println(celsius); float fahrenheit = ((celsius * 9) / 5 + 32); delay(1000); }
Runs repeatedly after setup() finishes.
int analogValue = analogRead(outputpin);
Reads the analog value from pin A0 and stores it in analogValue.
float millivolts = (analogValue / 1024.0) * 3300;
Converts the analog value to millivolts. 1024.0 represents the resolution of the analog-to-digital converter (10-bit), and 3300 is the voltage reference in millivolts provided by NodeMCU.
float celsius = millivolts / 10;
Converts the millivolts to degrees Celsius. The division by 10 is based on the sensor's characteristics.
Serial.print("in DegreeC= ");
Prints the text "in DegreeC= " to the serial monitor.
Serial.println(celsius);
Prints the Celsius temperature value to the serial monitor and moves to the next line.
float fahrenheit = ((celsius * 9) / 5 + 32);
Converts the Celsius temperature to Fahrenheit.
delay(1000);
Pauses the program for 1000 milliseconds (1 second).
##Summary:
The program reads an analog value from a sensor connected to pin A0, converts it to temperature in Celsius and Fahrenheit, and prints the temperature values to the serial monitor every second.

#EX3
##Variable Declaration:
int ledPin = 12;
Declares a variable named ledPin and assigns it the value 12, referring to the digital pin 12 on the Arduino board, which is connected to an LED.
int inputPin = 13;
Declares a variable named inputPin and assigns it the value 13, referring to the digital pin 13 on the Arduino board, which is connected to a digital input (e.g., a button).
int val = 0;
Declares a variable named val and initializes it to 0. This variable will store the state of the input pin.
##setup() Function:
void setup() { pinMode(ledPin, OUTPUT); pinMode(inputPin, INPUT); }
Runs once when the Arduino is powered on or reset.
Configures pin 12 (ledPin) as an output pin using pinMode(ledPin, OUTPUT);.
Configures pin 13 (inputPin) as an input pin using pinMode(inputPin, INPUT);.
##loop() Function:
void loop() { val = digitalRead(inputPin); if (val == HIGH) { digitalWrite(ledPin, LOW); } else { digitalWrite(ledPin, HIGH); } }
Runs repeatedly after setup() finishes.
val = digitalRead(inputPin);
Reads the state of the digital input pin 13 and stores it in val. The state can be either HIGH (button pressed) or LOW (button not pressed).
if (val == HIGH) { digitalWrite(ledPin, LOW); }
If the input pin state is HIGH (e.g., button pressed), sets the LED pin (12) to LOW, turning the LED off.
else { digitalWrite(ledPin, HIGH); }
If the input pin state is LOW (e.g., button not pressed), sets the LED pin (12) to HIGH, turning the LED on.
##Summary:
The program reads the state of a digital input connected to pin 13 and turns an LED connected to pin 12 on or off based on this state. When the input pin is HIGH (e.g., button pressed), the LED is turned off. When the input pin is LOW (e.g., button not pressed), the LED is turned on.

#EX4
##Variable Declaration:
int a = 0;
Declares a variable named a and initializes it to 0. This variable will store the analog input value.
int b = 0;
Declares a variable named b and initializes it to 0. This variable will store the mapped analog value.
##setup() Function:
void setup() { Serial.begin(9600); pinMode(13, OUTPUT); }
Runs once when the Arduino is powered on or reset.
Initializes serial communication at a baud rate of 9600 bits per second using Serial.begin(9600);.
Configures pin 13 as an output pin using pinMode(13, OUTPUT);.
##loop() Function:
void loop() { a = analogRead(A0); b = map(a, 0, 1023, 0, 255); Serial.println(b); if (b > 100) { Serial.println("Motion detected"); delay(100); } }
Runs repeatedly after setup() finishes.
a = analogRead(A0);
Reads the analog value from pin A0 and stores it in a. The value ranges from 0 to 1023.
b = map(a, 0, 1023, 0, 255);
Maps the analog value a from the range 0-1023 to the range 0-255 and stores the result in b.
Serial.println(b);
Prints the mapped value b to the serial monitor.
if (b > 100) { Serial.println("Motion detected"); delay(100); }
Checks if the mapped value b is greater than 100.
If b is greater than 100, prints "Motion detected" to the serial monitor and pauses the program for 100 milliseconds using delay(100);.
##Summary:
The program reads an analog value from pin A0, maps it to a range of 0-255, and prints the mapped value to the serial monitor. If the mapped value exceeds 100, it prints "Motion detected" to the serial monitor and pauses for 100 milliseconds. This process repeats indefinitely.

#EX5
##Variable Declaration:
int cm = 0;
Declares a variable named cm and initializes it to 0. This variable will store the distance in centimeters.
Function to Read Ultrasonic Distance:
long readUltrasonicDistance(int triggerPin, int echoPin) { pinMode(triggerPin, OUTPUT); digitalWrite(triggerPin, LOW); delayMicroseconds(2); digitalWrite(triggerPin, HIGH); delayMicroseconds(10); digitalWrite(triggerPin, LOW); pinMode(echoPin, INPUT); return pulseIn(echoPin, HIGH); }
This function takes two parameters, triggerPin and echoPin, which are the pins connected to the ultrasonic sensor's trigger and echo pins, respectively.
pinMode(triggerPin, OUTPUT);
Configures the triggerPin as an output pin.
digitalWrite(triggerPin, LOW); delayMicroseconds(2);
Clears the trigger pin by setting it to LOW for 2 microseconds.
digitalWrite(triggerPin, HIGH); delayMicroseconds(10); digitalWrite(triggerPin, LOW);
Sets the trigger pin to HIGH for 10 microseconds to send out an ultrasonic pulse.
pinMode(echoPin, INPUT);
Configures the echoPin as an input pin.
return pulseIn(echoPin, HIGH);
Measures the time (in microseconds) it takes for the ultrasonic pulse to return and sets the echoPin to HIGH.
##setup() Function:
void setup() { pinMode(11, OUTPUT); }
Runs once when the Arduino is powered on or reset.
Configures pin 11 as an output pin using pinMode(11, OUTPUT);. This pin is connected to an LED.
##loop() Function:
void loop() { cm = 0.01723 * readUltrasonicDistance(7, 7); if (cm < 50) { digitalWrite(11, HIGH); } else { digitalWrite(11, LOW); } delay(100); }
Runs repeatedly after setup() finishes.
cm = 0.01723 * readUltrasonicDistance(7, 7);
Calls the readUltrasonicDistance() function with both the trigger and echo pins set to pin 7. The function returns the pulse duration in microseconds, which is then multiplied by 0.01723 to convert it to centimeters. The result is stored in the variable cm.
if (cm < 50) { digitalWrite(11, HIGH); } else { digitalWrite(11, LOW); }
Checks if the distance cm is less than 50 centimeters.
If cm is less than 50 centimeters, sets pin 11 to HIGH, turning the LED on.
If cm is 50 centimeters or greater, sets pin 11 to LOW, turning the LED off.
delay(100);
Pauses the program for 100 milliseconds.
##Summary:
The program measures the distance using an ultrasonic sensor connected to pins 7 (for both trigger and echo). It converts the measured distance to centimeters and stores it in the variable cm. If the distance is less than 50 centimeters, the LED connected to pin 11 is turned on. Otherwise, the LED is turned off. This process repeats every 100 milliseconds.

#EX6
This is an Arduino program that reads temperature data from an analog sensor, connects to a WiFi network, and uploads the temperature data to ThingSpeak at regular intervals.
##Include Libraries:
include <ESP8266WiFi.h>
Includes the library for WiFi functionalities on the ESP8266 board.
include "ThingSpeak.h"
Includes the library for interacting with the ThingSpeak platform.
##Variable Declarations:
char msg[50];
const char* ssid = "boolean";
Stores the WiFi network's SSID.
const char* password = "meow meow";
Stores the WiFi network's password.
WiFiClient client;
unsigned long myChannelNumber = 00000000;
Stores the ThingSpeak channel number (replace with your channel number).
const char *myWriteAPIKey = "UGGIHGJNIH 云";
Stores the ThingSpeak write API key (replace with your write API key).
unsigned long lastTime = 0;
unsigned long timerDelay = 30000;
Time variables to manage the timing for data uploads (30 seconds).
float temperature;
Stores the temperature reading.
int outputPin = A0;
Defines the analog input pin for reading the temperature sensor.
##setup() Function:
void setup() {
Initializes serial communication at 115200 baud using Serial.begin(115200);.
Sets the WiFi mode to station mode using WiFi.mode(WIFI_STA);.
Initializes ThingSpeak with the client using ThingSpeak.begin(client);.
Prints the attempt to connect to the specified SSID.
Attempts to connect to the WiFi network in a loop until a connection is established.
Prints "Connected to WiFi" when connected.
##loop() Function:
void loop() {
Checks if 30 seconds have passed since the last upload using if ((millis() - lastTime) > timerDelay) {.
Reads the analog value from pin A0 and stores it in analogValue using int analogValue = analogRead(outputPin);.
Converts the analog value to millivolts and then to temperature in Celsius.
Prints the temperature in Celsius to the serial monitor.
Sends the temperature data to ThingSpeak using ThingSpeak.writeField().
Prints a success or error message based on the HTTP response.
Updates lastTime with the current time using lastTime = millis();.
##Summary:
The program reads temperature data from a sensor connected to pin A0, connects to a specified WiFi network, and uploads the temperature data to ThingSpeak every 30 seconds. It also prints the temperature and status messages to the serial monitor.

#EX7
This Arduino program connects to a WiFi network, writes random data to a ThingSpeak channel, and blinks an LED to indicate status.
##Library Inclusions:
Included libraries: ESP8266WiFi.h, WiFiClient.h, ThingSpeak.h.
##Constants:
WiFi credentials: const char* ssid = "YOUR_WIFI_SSID";, const char* password = "YOUR_WIFI_PASSWORD";.
ThingSpeak channel details: unsigned long channelID = YOUR_CHANNEL_ID;, const char* writeAPIKey = "YOUR_WRITE_API_KEY";.
LED pin: const int ledPin = 13;.
WiFi Client Initialization:
WiFiClient client; used for WiFi communication.
##Setup Function:
void setup() { ... }
Initializes serial communication: Serial.begin(115200);.
Connects to the WiFi network: WiFi.begin(ssid, password);.
Waits for WiFi connection: while (WiFi.status() != WL_CONNECTED) { delay(500); Serial.print("."); }.
Initializes ThingSpeak client: ThingSpeak.begin(client);.
Configures LED pin as output: pinMode(ledPin, OUTPUT);.
##Loop Function:
void loop() { ... }
Writes random data (0-99) to ThingSpeak field 1: ThingSpeak.writeField(channelID, 1, random(0, 100), writeAPIKey);.
Checks if channel update was successful (status == 200): if (status == 200) { ... }.
Blinks LED for status indication: digitalWrite(ledPin, HIGH); delay(1000); digitalWrite(ledPin, LOW); delay(1000);.
Delays for 20 seconds before sending the next update: delay(20000);.
##Summary:
This program repeatedly updates a ThingSpeak channel with random data every 20 seconds, provides feedback via the serial monitor, and blinks an LED connected to pin 13 on and off to indicate the update status. Adjust WiFi credentials, ThingSpeak channel details, and LED pin as needed for your specific setup.

#EX8
This Arduino program connects to a WiFi network, writes random data to a ThingSpeak channel, and controls two LEDs to indicate status.
##Library Inclusions:
Libraries included: ESP8266WiFi.h, WiFiClient.h, ThingSpeak.h.
##Constants:
WiFi credentials:
const char* ssid = "your-wifi-ssid";
const char* password = "your-wifi-password";
ThingSpeak channel details:
unsigned long channelID = your_channel_ID; (Replace with your ThingSpeak channel ID)
const char* writeAPIKey = "your-write-API-key"; (Replace with your ThingSpeak write API key)
LED pin assignments:
const int ledPin = 0; (GPIO0)
const int ledPin2 = D3; (GPIO0 on NodeMCU, labeled as D3)
WiFi Client Initialization:
WiFiClient client; (Client for WiFi communication)
##Setup Function:
void setup() {
Serial.begin(115200); // Initialize serial communication

WiFi.begin(ssid, password); // Connect to WiFi network

while (WiFi.status() != WL_CONNECTED) { // Wait for WiFi connection
delay(500);
Serial.print(".");
}

Serial.println("");
Serial.println("WiFi connected");

ThingSpeak.begin(client); // Initialize ThingSpeak client

pinMode(ledPin, OUTPUT); // Set LED pin as output
pinMode(ledPin2, OUTPUT); // Set second LED pin as output
}
Initializes serial communication at 115200 baud rate.
Connects to the WiFi network using WiFi.begin(ssid, password).
Waits until WiFi connection is established (WL_CONNECTED status).
Initializes the ThingSpeak client with ThingSpeak.begin(client).
Configures ledPin (GPIO0) and ledPin2 (D3 on NodeMCU) as output pins using pinMode().
##Loop Function:
void loop() {
  int status = ThingSpeak.writeField(channelID, 1, random(0, 100), writeAPIKey); // Write random data to ThingSpeak field 1

  if (status == 200) { // Check if channel update was successful
    Serial.println("Channel update successful!");
    digitalWrite(ledPin, HIGH); // Turn on first LED
    digitalWrite(ledPin2, HIGH); // Turn on second LED
    delay(1000); // Wait for 1 second
    digitalWrite(ledPin, LOW); // Turn off first LED
    digitalWrite(ledPin2, LOW); // Turn off second LED
    delay(1000); // Wait for 1 second
  } else {
    Serial.print("Problem updating channel. HTTP error code: ");
    Serial.println(status); // Print HTTP error code
  }

  delay(20000); // Wait for 20 seconds before sending the next update
}
Generates a random integer between 0 and 99 (random(0, 100)) and sends it to ThingSpeak field 1 using ThingSpeak.writeField().
Checks if the update was successful (status == 200).
Prints messages to the serial monitor indicating the status of the channel update.
Controls two LEDs (ledPin and ledPin2) to blink for 1 second each, indicating the update status.
Delays execution for 20 seconds (delay(20000)) before sending the next update to ThingSpeak.
##Summary:
This program continuously updates a ThingSpeak channel with random data every 20 seconds, provides feedback via the serial monitor, and blinks two LEDs connected to GPIO pin 0 and D3 on NodeMCU to indicate the update status. Adjust WiFi credentials, ThingSpeak channel details, and LED pin assignments as needed for your specific setup.

#EX9
This Python script interacts with ThingSpeak to read data from a specific channel and controls an LED based on the retrieved data.

Imports:

import requests: Imports the requests library for making HTTP requests.
import RPi.GPIO as GPIO: Imports the RPi.GPIO library for controlling GPIO pins on a Raspberry Pi.
import time: Imports the time module for adding delays.
Constants:

Channel ID and Read API Key:
channel_id = "your_channel_id": Replace with your ThingSpeak channel ID.
read_api_key = "your_read_api_key": Replace with your ThingSpeak read API key.
LED Pin:
led_pin = 18: Specifies the GPIO pin connected to the LED (GPIO pin 18).
GPIO Setup:

Sets up GPIO using BCM numbering:
GPIO.setmode(GPIO.BCM)
Configures led_pin as an output:
GPIO.setup(led_pin, GPIO.OUT)
ThingSpeak URL:

Constructs the ThingSpeak URL for retrieving the last entry in Field 1 of the specified channel:
url = f"https://api.thingspeak.com/channels/{channel_id}/fields/1/last.json?api_key={read_api_key}"
Main Loop:

python
Copy code
try:
    while True:
        response = requests.get(url)
        
        if response.status_code == 200:
            led_state = int(response.json()["field1"])
            if led_state:
                GPIO.output(led_pin, GPIO.HIGH)
            else:
                GPIO.output(led_pin, GPIO.LOW)
        else:
            print("Error loading data from ThingSpeak")

        time.sleep(15)  # Wait for 15 seconds before checking again

except KeyboardInterrupt:
    GPIO.cleanup()
Runs an infinite loop to continuously check ThingSpeak for updates.
Uses requests.get(url) to fetch data from the ThingSpeak URL.
Checks if the HTTP response status code is 200 (OK).
Retrieves the value of Field 1 (field1) from the JSON response and converts it to an integer (led_state).
Controls the LED (led_pin) based on the value of led_state:
Turns the LED on (GPIO.HIGH) if led_state is non-zero.
Turns the LED off (GPIO.LOW) if led_state is zero.
Prints an error message if there's an issue loading data from ThingSpeak.
Delays execution for 15 seconds (time.sleep(15)) before checking ThingSpeak again.
Cleanup on KeyboardInterrupt:
Cleans up GPIO settings when the program is interrupted (e.g., by pressing Ctrl+C):
GPIO.cleanup()
##Summary:
This script continuously monitors a ThingSpeak channel for updates, reads the value from Field 1, and toggles an LED connected to GPIO pin 18 on a Raspberry Pi based on the received data. Adjust the channel_id and read_api_key variables to match your ThingSpeak channel configuration.

#EX10
This Python script interacts with ThingSpeak to read data from multiple fields of a specific channel and controls LEDs based on the retrieved data.
##Imports:
import requests: Imports the requests library for making HTTP requests.
import RPi.GPIO as GPIO: Imports the RPi.GPIO library for controlling GPIO pins on a Raspberry Pi.
import time: Imports the time module for adding delays.
##Constants:
##Channel ID and Read API Key:
channel_id = "your_channel_id": Replace with your ThingSpeak channel ID.
read_api_key = "your_read_api_key": Replace with your ThingSpeak read API key.
##LED Pins:
led_pins = [18, 23, 24]: Specifies the GPIO pins connected to the LEDs (GPIO pins 18, 23, and 24).
##GPIO Setup:
Sets up GPIO using BCM numbering:
##GPIO.setmode(GPIO.BCM)
Configures each led_pin in led_pins list as an output:
for led_pin in led_pins:
    GPIO.setup(led_pin, GPIO.OUT)
##ThingSpeak URL Base:
Constructs the base URL for fetching the last entry in each field of the specified channel:
url_base = f"https://api.thingspeak.com/channels/{channel_id}/fields/"
##Main Loop:
try:
    while True:
        for i, led_pin in enumerate(led_pins):
            # Construct the URL for the current field
            url = f"{url_base}{i+1}/last.json?api_key={read_api_key}"

            response = requests.get(url)
            if response.status_code == 200:
                # Get the value of the current field from the JSON response
                led_state = int(response.json().get(f"field{i + 1}", 0))
                if led_state:
                    GPIO.output(led_pin, GPIO.HIGH)
                else:
                    GPIO.output(led_pin, GPIO.LOW)
            else:
                print(f"Error loading data from ThingSpeak for field {i+1}")

        time.sleep(15)  # Wait for 15 seconds before checking again

except KeyboardInterrupt:
    GPIO.cleanup()
Runs an infinite loop to continuously check ThingSpeak for updates.
Iterates through each led_pin in led_pins to fetch data from corresponding ThingSpeak fields.
Constructs the URL for each field using f"{url_base}{i+1}/last.json?api_key={read_api_key}".
Uses requests.get(url) to fetch data from ThingSpeak.
Checks if the HTTP response status code is 200 (OK).
Retrieves the value of the current field (field{i + 1}) from the JSON response and converts it to an integer (led_state).
Controls the LED (led_pin) based on the value of led_state:
Turns the LED on (GPIO.HIGH) if led_state is non-zero.
Turns the LED off (GPIO.LOW) if led_state is zero.
Prints an error message if there's an issue loading data from ThingSpeak.
Delays execution for 15 seconds (time.sleep(15)) before checking ThingSpeak again.
##Cleanup on KeyboardInterrupt:
Cleans up GPIO settings when the program is interrupted (e.g., by pressing Ctrl+C):
python
Copy code
GPIO.cleanup()
##Summary:
This script continuously monitors multiple ThingSpeak fields for updates, reads the values, and controls LEDs connected to GPIO pins 18, 23, and 24 on a Raspberry Pi based on the retrieved data. Adjust channel_id, read_api_key, and led_pins as needed for your specific ThingSpeak channel configuration and hardware setup.









