package intervalscheduling;
public class Element {
    int start, end, profit, num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
    public Element(int num, int start, int end , int profit) {
        this.num = num;
        this.start = start;
        this.end =  end;
        this.profit = profit;
    }
   
    
}
