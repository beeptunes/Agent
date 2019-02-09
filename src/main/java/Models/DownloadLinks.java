package Models;

/**
 * Created by javad on 12/29/2018 AD.
 */

public class DownloadLinks {
    public L64 L64;
    public L128 L128;
    public H320 H320;

    private abstract class Quality {
        public String url;
        public int size;
        public String crc;
    }

    private class L64 extends Quality{

    }
    private class L128 extends Quality{

    }

    private class H320 extends Quality{

    }


}
