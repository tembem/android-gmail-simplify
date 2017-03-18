package info.androidhive.gmail.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by jim on 3/17/17.
 */

public class Font {
    public static final Font  PROXIMA_NOVA    = new Font("Dosis-Regular.otf");
    public static final Font  PATUA_ONE    = new Font("PatuaOne-Regular.ttf");
    private final String      assetName;
    private volatile Typeface typeface;

    private Font(String assetName) {
        this.assetName = assetName;
    }

    public void apply(Context context, TextView textView) {
        if (typeface == null) {
            synchronized (this) {
                if (typeface == null) {
                    typeface = Typeface.createFromAsset(context.getAssets(), assetName);
                }
            }
        }
        textView.setTypeface(typeface);
    }
}
