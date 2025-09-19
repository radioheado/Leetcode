class Spreadsheet:

    def __init__(self, rows: int):
        self.sheet = defaultdict(int)

    def setCell(self, cell: str, value: int) -> None:
        self.sheet[cell] = value

    def resetCell(self, cell: str) -> None:
        self.sheet[cell] = 0

    def getValue(self, formula: str) -> int:
        var = formula.split('+')
        x, y = var[0][1:], var[1]

        if x.isdigit():
            x = int(x)
        else:
            x = self.sheet[x]

        if y.isdigit():
            y = int(y)
        else:
            y = self.sheet[y]
        return x + y


# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)