class Spreadsheet {
    Map<String, Integer> sheet;

    public Spreadsheet(int rows) {
        sheet = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell, value);
    }
    
    public void resetCell(String cell) {
        sheet.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] vars = formula.split("\\+");
        String x = vars[0].substring(1), y = vars[1];
        int x_val = 0, y_val = 0;
        
        x_val = isCell(x) ? sheet.getOrDefault(x, 0) : Integer.parseInt(x);
        y_val = isCell(y) ? sheet.getOrDefault(y, 0) : Integer.parseInt(y);
        return x_val + y_val;
    }

    private boolean isCell(String s) {
        return s.charAt(0) - 'A' >= 0 && s.charAt(0) - 'A' < 26;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */