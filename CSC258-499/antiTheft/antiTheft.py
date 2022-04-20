import machine
import utime
from lcd1602 import LCD
import random as r

def playMusic(speaker):
    A, B, Csharp, D, E, Fsharp = 440, 493, 554, 587, 659, 740
    # music note freq A, B, C#, D, E, F#
    duty_cycle = 30000
    tempo = 0.25
    # song tempo
    song = [[A, B, D, B, Fsharp, Fsharp, E],
            [A, B, D, B, E, E, D, Csharp, B],
            [A, B, D, B, D, E, Csharp, A, A, E, D]]
    # music
    i = 0
    # simple counter
    while i < 2:
        speaker.freq(song[0][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        i += 1
    while i < 4:
        speaker.freq(song[0][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        i += 1
        utime.sleep_ms(5)
    while i < 7:
        speaker.freq(song[0][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        i += 1
        utime.sleep_ms(85)
    utime.sleep(.01)
    # end of line one
    i = 0
    while i < 6:
        speaker.freq(song[1][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        i += 1
    while i < 9:
        speaker.freq(song[1][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        utime.sleep_ms(25)
        i += 1
    # end of line two
    i = 0
    utime.sleep_ms(85)
    while i < 7:
        speaker.freq(song[2][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        i += 1
    while i < 11:
        speaker.freq(song[2][i])
        speaker.duty_u16(duty_cycle)
        utime.sleep(tempo)
        speaker.duty_u16(0)
        i += 1
        utime.sleep_ms(15)
  

def alertTone(speaker):
    i = 0
    # simple counter
    while i < 4:
        sound = r.randint(150, 1000)
        speaker.freq(sound)
        # alarm freq is randomized
        speaker.duty_u16(40000)
        utime.sleep_ms(95)
        speaker.duty_u16(0)
        i += 1

def alert(led, speakerStatus, speaker):
    if speakerStatus == 0:
        # check if unmuted
        alertTone(speaker)
        # playMusic(speaker)
        blinkLED(led)
    else:
        blinkLED(led)
        utime.sleep_ms(135)

def motionTest(motion):
        motion.irq(trigger=machine.Pin.IRQ_RISING, handler=motionAlert)

def motionAlert(pin):
    alert(indicator_led, speaker_status, buzzer)
    # honestly, don't know why this works. Not in scope but...
    # perhaps is considering those global variables. no idea.

def setSpeakerStatus(status, switch):
    # when value == 1, mute [button]
    # 0 = off (unmuted), 1 = on (muted) [state]
    if switch.value() == 1:
        if status == 0:
            print("Muted Speaker")
            return 1
            # mute it
        elif status == 1:
            return 1
            # leave it alone
    if switch.value() == 0:
        if status == 0:
            return 0
            # leave it alone
        elif status == 1:
            print("Unmuted Speaker")
            return 0
            # unmute it

def blinkLED(led):
    led.value(1)
    utime.sleep_ms(45)
    led.value(0)

def initSecurityMessage(lcd):
    lcd.message("Security Level:\n low")

def setSecurityLevel(lcd, sl, button):
    # sl is security level
    while button.value() == 0:
        utime.sleep(.01)
    lcd.clear()
    if sl == 1:
        sl = 2
        lcd.message("Security Level:\n medium")
        # set medium
    elif sl == 2:
        sl = 3
        lcd.message("Security Level:\n high")
        # set high
    elif sl == 3:
        sl = 1
        lcd.message("Security Level:\n low")
        # set low
    return sl

def printSL(sl, lcd):
    if sl == 1:
        lcd.message("Security Level:\n low")
    elif sl == 2:
        lcd.message("Security Level:\n medium")
    elif sl == 3:
        lcd.message("Security Level:\n high")

motion_sensor = machine.Pin(18, machine.Pin.IN)
# motion sensor lol

buzzer = machine.PWM(machine.Pin(16))
# use 1kohm

speaker_status = 0
# 0 = off (unmuted), 1 = on (muted)
mute_switch = machine.Pin(15, machine.Pin.IN)
# use switch to mute speaker (when value == 1 (ON), mute)

tilt_switch = machine.Pin(14, machine.Pin.IN)
# if value = 0 the switch is being tilted.

lcd_msgr = LCD()
# LCD is fat so it gets GPIO 12/13 -- SCL = 13, SDA = 12

indicator_led = machine.Pin(11, machine.Pin.OUT)
# use 330ohm

mode_button = machine.Pin(10, machine.Pin.IN)
# if value = 0 the button is being pressed

authorize_button = machine.Pin(9, machine.Pin.IN)
# if value = 0 the button is being pressed

security_level = 1
# 1 = low, 2 = medium, 3 = high

initSecurityMessage(lcd_msgr)
# print security message (DEFAULT IS 1 [low])

while True:
    if mode_button.value() == 0:
        security_level = setSecurityLevel(lcd_msgr, security_level, mode_button)
        # if the button is pressed, change the mode, update security level
    
    speaker_status = setSpeakerStatus(speaker_status, mute_switch)
    # runs every loop
    
    if security_level == 1:
        # only tilt
        if tilt_switch.value() == 0:
            # when tilted will trigger alert
            alert(indicator_led, speaker_status, buzzer)
    elif security_level == 2:
        motionTest(motion_sensor)
        # only PIR (motion sensor)
        # trip alarm and reset status
    elif security_level == 3:
        # both
        if tilt_switch.value() == 0:
            # when tilted will trigger alert
            alert(indicator_led, speaker_status, buzzer)
        motionTest(motion_sensor)
        
    
    utime.sleep_ms(15)