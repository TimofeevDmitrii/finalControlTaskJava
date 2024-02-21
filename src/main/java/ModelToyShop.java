
public class ModelToyShop {

    private ToyStore toyStore;

    public void getPrize(int numberOfPlays){
        int count=0;
        while (count!=numberOfPlays){
            toyLottery();
        }
    }

    private Toy toyLottery(){
        return new Toy(1,"someToy",10);
    }


}
