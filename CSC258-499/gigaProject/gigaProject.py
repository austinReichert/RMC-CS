import time
import board
import analogio
import digitalio
import usb_hid
from adafruit_hid.mouse import Mouse

def mainLoop():
    dpi = 1
    flag = False
    LMBstatus = False
    RMBstatus = False
    while True:
        flag = checkFlag(flag)
        while flag == True:
            dpi = checkUpdateDPI(dpi)
            LMBstatus = checkMB(leftMB, LMBstatus, 0)
            RMBstatus = checkMB(rightMB, RMBstatus, 1)
            moveMouse(dpi)
            flag = checkFlag(flag)
            time.sleep(0.01)

def toggleLED():
    if indicatorLED.value == True:
        indicatorLED.value = False
    elif indicatorLED.value == False:
        indicatorLED.value = True

def whileButtonPress(button):
    while button.value == False:
        pass

def checkMB(MB, status, ind):
    # ind is flag (Left=0,Right=1)
    if MB.value == False:
        if status == False:
        # if MB is pressed and not clicked
            pressLeftRight(ind)
            return True
        elif status == True:
            return status
    elif MB.value == True:
        if status == True:
            # if not pressed and already clicked
            releaseLeftRight(ind)
            return False
        elif status == False:
            return status

def pressLeftRight(indicator):
    if indicator == 0:
        mouse.press(Mouse.LEFT_BUTTON)
    elif indicator == 1:
        mouse.press(Mouse.RIGHT_BUTTON)

def releaseLeftRight(indicator):
    if indicator == 0:
        mouse.release(Mouse.LEFT_BUTTON)
    elif indicator == 1:
        mouse.release(Mouse.RIGHT_BUTTON)

def checkUpdateDPI(dpi):
    if dpiButton.value == False:
        whileButtonPress(dpiButton)
        if dpi == 1:
            dpi = 2
        elif dpi == 2:
            dpi = 3
        elif dpi == 3:
            dpi = 4
        elif dpi == 4:
            dpi = 1
    return dpi

def calculateMove(axis):
    direction = 0
    if axis.value > 35000:
        direction = 5
    elif 30000 <= axis.value <= 35000:
        direction = 0
    elif axis.value < 30000:
        direction = -5
    return direction


def moveMouse(dpi):
    xToMove = (calculateMove(xAxis)*dpi)
    yToMove = (calculateMove(yAxis)*dpi)
    if xToMove != 0 or yToMove != 0:
        mouse.move(x=xToMove, y=yToMove)

def checkFlag(flag):
    if onOffButton.value == False:
        whileButtonPress(onOffButton)
        if flag == True:
            toggleLED()
            return False
        elif flag == False:
            toggleLED()
            return True
        else:
            return flag
    else:
        return flag

xAxis = analogio.AnalogIn(board.GP27)
yAxis = analogio.AnalogIn(board.GP26)
indicatorLED = digitalio.DigitalInOut(board.GP12)
indicatorLED.direction = digitalio.Direction.OUTPUT
onOffButton = digitalio.DigitalInOut(board.GP13)
dpiButton = digitalio.DigitalInOut(board.GP14)
rightMB = digitalio.DigitalInOut(board.GP15)
leftMB = digitalio.DigitalInOut(board.GP16)
leftMB.pull = digitalio.Pull.UP
mouse = Mouse(usb_hid.devices)

mainLoop()
