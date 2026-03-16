public class CCharacter {
    private String character; // separated by ;
    private String pinyin; // separated by ;

    private String meaning; // in text file, start with [ then ] and everything in-between is meaning

    private final int CHARACTER = 0;
    private final int PINYIN = 1;
    private final int MEANING = 2;

    public CCharacter(){
        this.pinyin = null;
        this.character = null;
        this.meaning = null;
    }

    public CCharacter(String cha, String pinyin, String meaning){
        this.character = cha;
        this.pinyin = pinyin;
        this.meaning = meaning;
    }

    public String getCharacter() {
        return character;
    }
    public String getPinyin() {
        return pinyin;
    }
    public String getMeaning() {
        return meaning;
    }

    // if a string response is correct to corresponding request
    public boolean doesMatch(String input, int category){
        switch(category){
            case 0:
                if(input.equals(character))
                    return true;
                break;
            case 1:
                if(input.equals(pinyin))
                    return true;
                break;
            case 2:
                if(input.equals(meaning))
                    return true;
                break;
            default:
                return false;
        }
        return false;
    }
}
