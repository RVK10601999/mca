import requests
import RPi.GPIO as GPIO
import time

# Channel ID and Read API Key
channel_id = "your_channel_id"
read_api_key = "your_read_api_key"

# LED Pin
led_pin = 18

# GPIO setup
GPIO.setmode(GPIO.BCM)
GPIO.setup(led_pin, GPIO.OUT)

# ThingSpeak URL
url = f"https://api.thingspeak.com/channels/{channel_id}/fields/1/last.json?api_key={read_api_key}"

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
