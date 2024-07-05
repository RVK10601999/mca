#include <ESP8266WiFi.h>
#include "ThingSpeak.h"

char msg[50];
const char* ssid = "boolean"; // your network SSID (name)
const char* password = "meow meow"; // your network password

WiFiClient client;

unsigned long myChannelNumber = 00000000; // replace with your channel number
const char *myWriteAPIKey = "UGGIHGJNIH 云"; // replace with your write API key

// Time variables
unsigned long lastTime = 0;
unsigned long timerDelay = 30000; // 30 seconds

// Variable to hold temperature readings
float temperature;
int outputPin = A0;

void setup() {
  Serial.begin(115200); // Initialize serial
  WiFi.mode(WIFI_STA);
  ThingSpeak.begin(client);

  Serial.print("Attempting to connect to SSID: ");
  Serial.println(ssid);

  while (WiFi.status() != WL_CONNECTED) {
    WiFi.begin(ssid, password);
    delay(10000); // Delay for 10 seconds
    Serial.print(".");
  }

  Serial.println("Connected to WiFi");
}

void loop() {
  if ((millis() - lastTime) > timerDelay) {
    int analogValue = analogRead(outputPin);
    float millivolts = (analogValue / 1024.0) * 3300;
    temperature = millivolts / 10; // Adjust the conversion factor as needed

    Serial.print("Temperature (°C): ");
    Serial.println(temperature);

    int x = ThingSpeak.writeField(myChannelNumber, 1, temperature, myWriteAPIKey);
    if (x == 200) {
      Serial.println("Channel update successful.");
    } else {
      Serial.println("Problem updating channel. HTTP error code " + String(x));
    }

    lastTime = millis();
  }
}
