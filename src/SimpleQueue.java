import java.util.NoSuchElementException;

public class SimpleQueue {
    String[] arrayList;
    private int tail;
    private int size;
    private int cap;
    public SimpleQueue(int Cap){
        if(Cap < 1){
            throw new IllegalArgumentException();
        }
        arrayList = new String[Cap];
        tail = -1;
        cap = Cap;
    }
    public boolean add(String s){
        if(s == null){
            throw new NullPointerException();
        }
        boolean result = offer(s);
        if(result == false){
            throw new IllegalStateException("Queue full");
        }else{
            return true;
        }
    }

    public void clear(){
        arrayList = new String[cap];
        tail = -1;
    }

    public boolean contains(String s){
        for(int i = 0; i < tail + 1; i++){
            if(arrayList[i] == s){
                return true;
            }
        }
        return false;
    }

    public String element() {
        String peek = peek();
        if(peek == null){
            throw new NoSuchElementException();
        }else {
            return arrayList[0];
        }
    }
    public boolean offer(String s) {
        if(tail + 1 == arrayList.length){
            return false;
        }else if (s == null){
            throw new NullPointerException();
        }else{
            arrayList[tail + 1] = s;
            tail++;
            return true;
        }
    }
    public String peek(){
        if(tail == -1){
            return null;
        }else{
            return arrayList[0];
        }
    }
    public String poll() {
        if(tail == -1){
            return null;
        }
        String returnString = peek();
        for(int i = 1; i < tail + 1; i++){
            arrayList[i-1] = arrayList[i];
        }
        tail--;
        return returnString;
    }

    public int remainingCapacity(){
        return arrayList.length - tail - 1;
    }
    public String remove(){
        String resultString = poll();
        if(resultString == null){
            throw new NoSuchElementException();
        }else{
            return resultString;
        }
    }

    public boolean remove(String s) {
        for(int i = 0; i < tail; i++){
            if(arrayList[i] == s){
                for(int j=i+1; j < tail+1; j++) {
                    arrayList[j-1] = arrayList[j];
                }
                tail--;
                return true;
            }
        }
        return false;
    }
    public int size(){
        return tail + 1;
    }

    public String toString(){
        size = size();
        String mainString = "[";
        if(tail != -1){
            for(int i=0; i<size; i++){
                String addString = "";
                addString = arrayList[i];
                if(i == tail){
                    mainString = mainString + addString;
                }
                else {
                    mainString = mainString + addString + ", ";
                }
            }
        }
        return mainString + "]";
    }
}

//all good
