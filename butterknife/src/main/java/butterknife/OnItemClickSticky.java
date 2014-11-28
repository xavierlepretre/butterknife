package butterknife;

import android.view.View;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Bind a method to an {@link android.widget.AdapterView.OnItemClickListener OnItemClickListener} on the
 * se.emilsjolander.stickylistheaders.StickyListHeadersListView view for each ID specified.
 * <pre><code>
 * {@literal @}OnItemClickSticky(R.id.example_list) void onItemClick(int position) {
 *   Toast.makeText(this, "Clicked position " + position + "!", LENGTH_SHORT).show();
 * }
 * </code></pre>
 * Any number of parameters from {@link android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView,
 * android.view.View, int, long) onItemClick} may be used on the method.
 *
 * @see android.widget.AdapterView.OnItemClickListener
 * @see butterknife.Optional
 */
@Target(METHOD)
@Retention(CLASS)
@ListenerClass(
    targetType = "se.emilsjolander.stickylistheaders.StickyListHeadersListView",
    setter = "setOnItemClickListener",
    type = "android.widget.AdapterView.OnItemClickListener",
    method = @ListenerMethod(
        name = "onItemClick",
        parameters = {
            "android.widget.AdapterView<?>",
            "android.view.View",
            "int",
            "long"
        }
    )
)
public @interface OnItemClickSticky
{
  /** View IDs to which the method will be bound. */
  int[] value() default { View.NO_ID };
}
