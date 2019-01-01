# EasyAdapter
An adapter to reduce time for writing boilerplate code and speed up build time for RecyclerView.

[![](https://jitpack.io/v/droidbond/easyadapter.svg)](https://jitpack.io/v/droidbond/easyadapter)

### Demo
<img src="https://github.com/droidbond/easyadapter/blob/master/device-2019-01-01-141001.png" width="250"> <img src="https://github.com/droidbond/easyadapter/blob/master/device-2019-01-01-141017.png" width="250">

## Installation (with Gradle)
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
dependencies {
		implementation 'com.github.droidbond:easyadapter:0.1.1'
	}
	
### How to use

For general RecyclerView:

```java
 recyclerView.setAdapter(new EasyAdapter.Builder<Integer>()
                .setLayout(R.layout.row_list)
                .setData(Arrays.asList(1, 2, 3, 4))
                .setCallback(new Callback<Integer>() {
                    @Override
                    public void onBindViewHolder(@NonNull EasyAdapter.Companion.ViewHolder viewHolder, @NonNull View itemView, int position, Integer item) {
                        TextView tv = viewHolder.itemView.findViewById(R.id.textView);
                        tv.setText(item.toString());
                    }
                })
                .build());

```

For RecyclerView with multiple section:

```java
recyclerView.setAdapter(new EasySectionedAdapter.Builder<Integer>()
                .setHeaderLayout(R.layout.row_header)
                .setChildLayout(R.layout.row_list)
                .setDataSet(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2), Arrays.asList(1, 2, 3)))
                .setCallback(new SectionedCallback<Integer>() {
                    @Override
                    public void onBindHeader(@NotNull EasyAdapter.Companion.ViewHolder viewHolder, int section) {
                        viewHolder.itemView.setBackgroundColor(Color.BLACK);
                        TextView tv = viewHolder.itemView.findViewById(R.id.textView);
                        tv.setTextColor(Color.WHITE);
                        tv.setText("Header");
                    }

                    @Override
                    public void onBindChild(@NotNull EasyAdapter.Companion.ViewHolder viewHolder, int section, int positionInSection, int position, Integer item) {
                        TextView tv = viewHolder.itemView.findViewById(R.id.textView);
                        tv.setText(item.toString());
                        tv.setTextColor(Color.BLACK);
                        viewHolder.itemView.setBackgroundColor(Color.WHITE);
                    }
                })
                .build());
```

To update dataset use ```Adapter.updateDataSet()``` with your new dataset.
For a complete example see sample app
