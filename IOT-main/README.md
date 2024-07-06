#EX1
##Summary:
The program turns the LED on for 1 second and then off for 1 second, repeating this cycle indefinitely. This results in the LED blinking on and off with a 1-second interval.

#EX2
##Summary:
The program reads an analog value from a sensor connected to pin A0, converts it to temperature in Celsius and Fahrenheit, and prints the temperature values to the serial monitor every second.

#EX3
##Summary:
The program reads the state of a digital input connected to pin 13 and turns an LED connected to pin 12 on or off based on this state. When the input pin is HIGH (e.g., button pressed), the LED is turned off. When the input pin is LOW (e.g., button not pressed), the LED is turned on.

#EX4
##Summary:
The program reads an analog value from pin A0, maps it to a range of 0-255, and prints the mapped value to the serial monitor. If the mapped value exceeds 100, it prints "Motion detected" to the serial monitor and pauses for 100 milliseconds. This process repeats indefinitely.

#EX5
##Summary:
The program measures the distance using an ultrasonic sensor connected to pins 7 (for both trigger and echo). It converts the measured distance to centimeters and stores it in the variable cm. If the distance is less than 50 centimeters, the LED connected to pin 11 is turned on. Otherwise, the LED is turned off. This process repeats every 100 milliseconds.

#EX6
##Summary:
The program reads temperature data from a sensor connected to pin A0, connects to a specified WiFi network, and uploads the temperature data to ThingSpeak every 30 seconds. It also prints the temperature and status messages to the serial monitor.

#EX7
##Summary:
This program repeatedly updates a ThingSpeak channel with random data every 20 seconds, provides feedback via the serial monitor, and blinks an LED connected to pin 13 on and off to indicate the update status. Adjust WiFi credentials, ThingSpeak channel details, and LED pin as needed for your specific setup.

#EX8
##Summary:
This program continuously updates a ThingSpeak channel with random data every 20 seconds, provides feedback via the serial monitor, and blinks two LEDs connected to GPIO pin 0 and D3 on NodeMCU to indicate the update status. Adjust WiFi credentials, ThingSpeak channel details, and LED pin assignments as needed for your specific setup.

#EX9
##Summary:
This script continuously monitors a ThingSpeak channel for updates, reads the value from Field 1, and toggles an LED connected to GPIO pin 18 on a Raspberry Pi based on the received data. Adjust the channel_id and read_api_key variables to match your ThingSpeak channel configuration.

#EX10
##Summary:
This script continuously monitors multiple ThingSpeak fields for updates, reads the values, and controls LEDs connected to GPIO pins 18, 23, and 24 on a Raspberry Pi based on the retrieved data. Adjust channel_id, read_api_key, and led_pins as needed for your specific ThingSpeak channel configuration and hardware setup.









