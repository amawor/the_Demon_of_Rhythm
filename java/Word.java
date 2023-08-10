public class Word {
    private String name,radical,phoneticNotation,meaning,polyphone,message;
    private int strokes,ex_radical,polyphoneRank;
    public Word(String name,String radical,String phoneticNotation,String meaning,int strokes,int ex_radical,String polyphone,String message,int polyphoneRank){
        this.name=name;
        this.radical=radical;
        this.phoneticNotation=phoneticNotation;
        this.meaning=meaning;
        this.strokes=strokes;
        this.ex_radical=ex_radical;
        this.polyphone=polyphone;
        this.message=message;
        this.polyphoneRank=polyphoneRank;
    }

    public String getName() {
        return name;
    }

    public String getRadical() {
        return radical;
    }

    public String getPhoneticNotation() {
        return phoneticNotation;
    }

    public String getMeaning() {
        return meaning;
    }

    public int getStrokes() {
        return strokes;
    }

    public int getEx_radical() {
        return ex_radical;
    }

    public String getPolyphone() {
        return polyphone;
    }

    public String getMessage() {
        return message;
    }

    public int getPolyphoneRank() {
        return polyphoneRank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRadical(String radical) {
        this.radical = radical;
    }

    public void setPhoneticNotation(String phoneticNotation) {
        this.phoneticNotation = phoneticNotation;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }

    public void setEx_radical(int ex_radical) {
        this.ex_radical = ex_radical;
    }

    public void setPolyphone(String polyphone) {
        this.polyphone = polyphone;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPolyphoneRank(int polyphoneRank) {
        this.polyphoneRank = polyphoneRank;
    }

    public String toString(){
        return "name:"+name+" radical:"+radical+" phoneticNotation:"+phoneticNotation+" meaning:"+meaning+" strokes:"+strokes+" ex_radical:"+ex_radical+" polyphone:"+polyphone+" message:"+message+" polyphoneRank:"+polyphoneRank;
    }
}