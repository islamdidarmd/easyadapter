# ExtendedRecyclerView
A small library to reduce time for writing boilerplate code and speed up build time

## Installation (with Gradle)
Just add the dependency to your *build.gradle*:

```groovy
   repositories {
        jcenter()
        maven { url "https://jitpack.io" }
   }
   dependencies {
         implementation 'com.github.droidbond:ExtendedRecyclerView:0.1.3'
   }
```
### How to use
Create a java/koltin class and extend ```ExtendedRecyclerViewAdapter```
Create a constructor matching super and implement ```onBindViewHolder``` method

##### Adapter
###### java
```java
public class MyAdapter extends ExtendedRecyclerViewAdapter {
    List<Integer> list;

    public MyAdapter(int layout, List<Integer> list, Callback callback) {
        super(layout, list, callback);
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(list.get(i).toString());
    }
}
```
###### kotlin
You can do this with much less code if you are using kotlin android extention
to use kotlin extention, add ```apply plugin: 'kotlin-android-extensions'``` on top of your *build.gradle*.
For details: https://kotlinlang.org/docs/tutorials/android-plugin.html

```kotlin
import com.didar.mylibrary.Callback
import com.didar.extendedrecyclerview.ExtendedRecyclerViewAdapter
import kotlinx.android.synthetic.main.row_list.view.*

class MyAdapter(layout: Int, internal var list: List<Int>, callback: Callback) :
        ExtendedRecyclerViewAdapter(layout, list, callback) {

    override fun onBindViewHolder(viewHolder: ExtendedRecyclerViewAdapter.ViewHolder, i: Int) {
        viewHolder.itemView.textView.text = list[i].toString()
    }
}

```
##### ListActivity.java
```java
MyAdapter adapter = new MyAdapter(R.layout.row_list, list,
                new Callback() {
                    @Override
                    public void onClick(int position, @NotNull View view, @NotNull Object item) {
                        Integer i = (Integer) item;
                        Log.d(TAG, "onClick: clicked " + i);
                    }

                    @Override
                    public void onLongClick(int position, @NotNull View view, @NotNull Object item) {
                        Integer i = (Integer) item;
                        Log.d(TAG, "onLongClick: onLongClick " + i);
                    }

                    @Override
                    public void onDataSetChanged(int newDataSetSize, @NotNull List<?> newDataSet) {
                        //when you call Adapter.updateDataSet you will get new dataset with size here
                    }
                });
```
To update dataset use ```adapter.updateDataSet()``` with your new dataset. After calling ```Adapter.updateDataSet()``` you will get a callback in ```onDataSetChanged``` method. 
If you use ```notifyDataSetChanged()```, you won't get this callback.

## Enjoy!
