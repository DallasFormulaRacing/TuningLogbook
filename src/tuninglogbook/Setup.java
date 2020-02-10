package tuninglogbook;

/**
 * Holds the setup data for a single row
 * @author Nolan Davenport
 */
public class Setup {
    public float[] setupData = new float[34];
    public float FRHSC = 0.0f; //0 - front right high speed compresssion
    public float FRHSR = 0.0f; //1 - front right high speed rebound
    public float FRLSC = 0.0f; //2 - front right low speed compression
    public float FRLSR = 0.0f; //3 - front right low speed rebound
    public float FLHSC = 0.0f; //4 - front left high speed compression
    public float FLHSR = 0.0f; //5 - front left high speed rebound
    public float FLLSC = 0.0f; //6 - front left low speed compression
    public float FLLSR = 0.0f; //7 - front left low speed rebound
    public float RRHSC = 0.0f; //8 - rear right high speed compression
    public float RRHSR = 0.0f; //9 - rear right high speed rebound
    public float RRLSC = 0.0f; //10 - rear right low speed compression
    public float RRLSR = 0.0f; //11 - rear right low speed rebound
    public float RLHSC = 0.0f; //12 - rear left high speed compression
    public float RLHSR = 0.0f; //13 - rear left high speed rebound
    public float RLLSC = 0.0f; //14 - rear left low speed compression
    public float RLLSR = 0.0f; //15 - rear left low speed rebound
    public float FARB = 0.0f; //16 - front anti roll bar
    public float RARB = 0.0f; //17 - rear anti roll bar
    public float FRS = 0.0f; //18 - front right spring
    public float FLS = 0.0f; //19 - front left spring
    public float RRS = 0.0f; //20 - rear right spring
    public float RLS = 0.0f; //21 - rear left spring
    public float RHF = 0.0f; //22 - right height front
    public float RHR = 0.0f; //23 - right height rear
    public float CF = 0.0f; //24 - camber front
    public float CR = 0.0f; //25 - camber rear
    public float TF = 0.0f; //26 - toe front
    public float TR = 0.0f; //27 - toe rear
    public float AA = 0.0f; //28 - ackermann angle
    public float TPFR = 0.0f; //29 - tire pressure front right
    public float TPFL = 0.0f; //30 - tire pressure front left
    public float TPRR = 0.0f; //31 - tire pressure rear right
    public float TPRL = 0.0f; //32 - tire pressure rear left
    public float BB = 0.0f; //33 - brake bias

    public Setup() {
        setupData[0] = FRHSC;
        setupData[1] = FRHSR;
        setupData[2] = FRLSC;
        setupData[3] = FRLSR;
        setupData[4] = FLHSC;
        setupData[5] = FLHSR;
        setupData[6] = FLLSC;
        setupData[7] = FLLSR;
        setupData[8] = RRHSC;
        setupData[9] = RRHSR;
        setupData[10] = RRLSC;
        setupData[11] = RRLSR;
        setupData[12] = RLHSC;
        setupData[13] = RLHSR;
        setupData[14] = RLLSC;
        setupData[15] = RLLSR;
        setupData[16] = FARB;
        setupData[17] = RARB;
        setupData[18] = FRS;
        setupData[19] = FLS;
        setupData[20] = RRS;
        setupData[21] = RLS;
        setupData[22] = RHF;
        setupData[23] = RHR;
        setupData[24] = CF;
        setupData[25] = CR;
        setupData[26] = TF;
        setupData[27] = TR;
        setupData[28] = AA;
        setupData[29] = TPFR;
        setupData[30] = TPFL;
        setupData[31] = TPRR;
        setupData[32] = TPRL;
        setupData[33] = BB;
    }
}
