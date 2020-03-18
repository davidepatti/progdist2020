public class Tv implements Advertisable {
    private int currentVolume;
    public void increaseVolume(){
        currentVolume++;
    }
    public void decreaseVolume(){
        currentVolume--;
    }

    @Override
    public String getLogo() {
        String logo = " /_T_V_/";
        return logo;
    }

    @Override
    public String getSlogan() {
        String slogan;
        slogan = " Even better that real thing!";
        return slogan;
    }
}
