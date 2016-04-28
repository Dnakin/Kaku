package ca.fuwafuwa.kaku.XmlParsers.JmDTO;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * The reading element typically contains the valid readings
 * of the word(s) in the kanji element using modern kanadzukai.
 * Where there are multiple reading elements, they will typically be
 * alternative readings of the kanji element. In the absence of a
 * kanji element, i.e. in the case of a word or phrase written
 * entirely in kana, these elements will define the entry.
 */
@Root(name = "r_ele")
public class JmREle {

    @Element(name = "reb")
    private String reb;
    @Element(name = "re_nokanji", required = false)
    private String re_nokanji;
    @ElementList(entry = "re_restr", inline = true, required = false)
    private List<String> re_restr;
    @ElementList(entry = "re_inf", inline = true, required = false)
    private List<String> re_inf;
    @ElementList(entry = "re_pri", inline = true, required = false)
    private List<String> re_pri;

    /**
     * this element content is restricted to kana and related
     * characters such as chouon and kurikaeshi. Kana usage will be
     * consistent between the keb and reb elements; e.g. if the keb
     * contains katakana, so too will the reb.
     */
    public String getReb(){
        return this.reb;
    }

    /**
     * This element, which will usually have a null value, indicates
     * that the reb, while associated with the keb, cannot be regarded
     * as a true reading of the kanji. It is typically used for words
     * such as foreign place names, gairaigo which can be in kanji or
     * katakana, etc.
     */
    public String getReNoKanji(){
        return this.re_nokanji;
    }

    /**
     * This element is used to indicate when the reading only applies
     * to a subset of the keb elements in the entry. In its absence, all
     * readings apply to all kanji elements. The contents of this element
     * must exactly match those of one of the keb elements.
     */
    public List<String> getReRestr(){
        return this.re_restr;
    }

    /**
     * General coded information pertaining to the specific reading.
     * Typically it will be used to indicate some unusual aspect of
     * the reading.
     */
    public List<String> getReInf(){
        return this.re_inf;
    }

    /**
     * See the comment on ke_pri above.
     */
    public List<String> getRePri(){
        return this.re_pri;
    }
}
