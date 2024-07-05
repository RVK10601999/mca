#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ThingSpeak.h>

const char* ssid = "your-wifi-ssid";
const char* password = "your-wifi-password";
unsigned long channelID = your_channel_ID; // Replace with your channel ID
const char* writeAPIKey = "your-write-API-key"; // Replace with your write API key
const int ledPin = 0; // GPIO0
const int ledPin2 = D3; // GPIO0 (D3 on NodeMCU)

WiFiClient client;

void setup() {
  Serial.begin(115200);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");

  ThingSpeak.begin(client);

  pinMode(ledPin, OUTPUT);
  pinMode(ledPin2, OUTPUT);
}

void loop() {
  int status = ThingSpeak.writeField(channelID, 1, random(0, 100), writeAPIKey);

  if (status == 200) {
    Serial.println("Channel update successful!");
    digitalWrite(ledPin, HIGH);
    digitalWrite(ledPin2, HIGH);
    delay(1000);
    digitalWrite(ledPin, LOW);
    digitalWrite(ledPin2, LOW);
    delay(1000);
  } else {
    Serial.print("Problem updating channel. HTTP error code: ");
    Serial.println(status);
  }

  delay(20000); // Wait 20 seconds before sending the next update
}
