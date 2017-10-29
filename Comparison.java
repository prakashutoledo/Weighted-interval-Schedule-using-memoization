package intervalscheduling;

import java.util.Comparator;

public class Comparison implements Comparator {

    Element e1;
    Element e2;

    public Comparison(Element e1, Element e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int compare(Object t1, Object t2) {
        e1 = (Element) t1;
        e2 = (Element) t2;
        if (e1.end <= e2.end) {
            return -1;
        } else {
            return 1;
        }
    }

}
