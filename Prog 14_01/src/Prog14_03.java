public class Prog14_03 {

    private int loc;
    public Prog14_03(){

    }
    public int locateLeftEnc(int[] list, int first, int last, int x){
        this.loc = 0;

        if(first > last) this.loc = first;
        else{
            int mid = (first+last)/2;
            System.out.println(mid+", ");
            if(x <= list[mid]){
                this.loc = locateLeftEnc(list, first, mid-1, x);
            }else{
                this.loc = locateLeftEnc(list, mid+1, last, x);
            }
        }
        return this.loc;
    }
}
