public class Items {
    public String Iname;
    public int Idamage;
    public int ItoHit;
    public int iAC;

    public Items(String iname, int Idamage, int ItoHit, int iAC) {
        Iname = iname;
        this.Idamage = Idamage;
        this.ItoHit = ItoHit;
        this.iAC = iAC;
    }


    public String getIname() {
        return Iname;
    }

    public void setIname(String iname) {
        Iname = iname;
    }

    public int getIdamage() {
        return Idamage;
    }

    public void setIdamage(int idamage) {
        Idamage = idamage;
    }

    public int getItoHit() {
        return ItoHit;
    }

    public void setItoHit(int itoHit) {
        ItoHit = itoHit;
    }

    public int getiAC() {
        return iAC;
    }

    public void setiAC(int iAC) {
        this.iAC = iAC;
    }
}
