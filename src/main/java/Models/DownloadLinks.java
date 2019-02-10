package Models;

/**
 * Created by javad on 12/29/2018 AD.
 */

public class DownloadLinks {
    private L64 L64;
    private L128 L128;
    private H320 H320;

    public DownloadLinks.L64 getL64() {
        return L64;
    }

    public void setL64(String url, int size, String crc) {
        this.L64 = new L64(url, size, crc);
    }

    public DownloadLinks.L128 getL128() {
        return L128;
    }

    public void setL128(String url, int size, String crc) {
        this.L128 = new L128(url, size, crc);
    }

    public DownloadLinks.H320 getH320() {
        return H320;
    }

    public void setH320(String url, int size, String crc) {
        this.H320 = new H320(url, size, crc);
    }

    @Override
    public boolean equals(Object obj) {
        final DownloadLinks downloadLinks = (DownloadLinks) obj;

        return
                this.L64.crc.equals(downloadLinks.L64.crc)
                && this.L128.crc.equals(downloadLinks.L128.crc)
                && this.H320.crc.equals(downloadLinks.H320.crc);
    }

    private abstract class Quality {
        public String url;
        public int size;
        public String crc;

        public Quality(String url, int size, String crc) {
            this.url = url;
            this.size = size;
            this.crc = crc;
        }
    }

    private class L64 extends Quality{
        public L64(String url, int size, String crc) {
            super(url, size, crc);
        }
    }
    private class L128 extends Quality{
        public L128(String url, int size, String crc) {
            super(url, size, crc);
        }
    }

    private class H320 extends Quality{
        public H320(String url, int size, String crc) {
            super(url, size, crc);
        }
    }


}
