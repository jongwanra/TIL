public class Calculator {

    private int total;
    public void sum(int ...values){

        for(int value: values){
            this.total += value;
        }
    }

    int getTotal(){
        return total;
    }

}
