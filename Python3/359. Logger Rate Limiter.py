class Logger:

    def __init__(self):
        self.msg = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        # if the message has not been printed yet
        # print it after saving it
        if message not in self.msg:
            self.msg[message] = timestamp
            return True
        
        # calculate the time diff
        if timestamp - self.msg[message] >= 10:
            self.msg[message] = timestamp
            return True
        
        return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)