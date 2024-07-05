#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ThingSpeak.h>

const char* ssid = "YOUR_WIFI_SSID";
const char* password = "YOUR_WIFI_PASSWORD";

unsigned long channelID = YOUR_CHANNEL_ID;
const char* writeAPIKey = "YOUR_WRITE_API_KEY";

const int ledPin = 13;

WiFiClient client;

void setup() {
  Serial.begin(115200);
  
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi Connected");

  ThingSpeak.begin(client);
  pinMode(ledPin, OUTPUT);
}

void loop() {
  int status = ThingSpeak.writeField(channelID, 1, random(0, 100), writeAPIKey);

  if (status == 200) {
    Serial.println("Channel update successful");
    digitalWrite(ledPin, HIGH);
    delay(1000);
    digitalWrite(ledPin, LOW);
    delay(1000);
  } else {
    Serial.print("Problem updating channel. HTTP error code: ");
    Serial.println(status);
  }

  delay(20000); // Wait 20 seconds before sending the next update
}
