import requests
import RPi.GPIO as GPIO
import time

# Channel ID and Read API Key
channel_id = "your_channel_id"
read_api_key = "your_read_api_key"

# LED Pins
led_pins = [18, 23, 24]

# GPIO setup
GPIO.setmode(GPIO.BCM)
for led_pin in led_pins:
    GPIO.setup(led_pin, GPIO.OUT)

# ThingSpeak URL base
url_base = f"https://api.thingspeak.com/channels/{channel_id}/fields/"

try:
    while True:
        for i, led_pin in enumerate(led_pins):
            # Construct the URL for the current field
            url = f"{url_base}{i+1}/last.json?api_key={read_api_key}"

            response = requests.get(url)
            if response.status_code == 200:
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
