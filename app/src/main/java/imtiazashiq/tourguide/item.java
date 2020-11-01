package imtiazashiq.tourguide;



public class item  {
    //Intialize private vars//
  private   String mTitle;
   private String mLocation;
   private String mWebsite;
    private int imageResource;
    private String mOverview;

    //Item constructor takes 5 params

    public item(String mTitle, String mLocation ,String mWebsite,int imageResource,String mOverview) {
        this.mTitle = mTitle;
        this.mLocation = mLocation;
        this.mWebsite=mWebsite;
        this.imageResource=imageResource;
        this.mOverview=mOverview;

    }
    //Setter and getter//


    public String getmTitle() {
        return mTitle;
    }


    public String getmLocation() {
        return mLocation;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public int getImageResource() {
        return imageResource;
    }
    public String getmOverview(){
        return mOverview;
    }
}
