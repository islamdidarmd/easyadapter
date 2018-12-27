# EasyAdapter
An adapter to reduce time for writing boilerplate code and speed up build time for RecyclerView.

[![](https://jitpack.io/v/droidbond/easyadapter.svg)](https://jitpack.io/v/droidbond/easyadapter)
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
```groovy
dependencies {
		implementation 'com.github.droidbond:easyadapter:0.1.0'
	}
```
### How to use
```java
recyclerView.setAdapter(new EasyAdapter.Builder<Integer>()
                .setLayout(R.layout.row_list)
                .setItemCount(list.size())
                .setData(list).setCallback(new Callback() {
                    @Override
                    public void onBindViewHolder(@NonNull EasyAdapter.Companion.ViewHolder viewHolder, @NonNull View itemView, int position) {
                        //TODO Bind your view Holder here.
                        TextView textView = itemView.findViewById(R.id.textView);
                        textView.setText(list.get(position).toString());
                    }
                }).build());

```
To update dataset use ```adapter.updateDataSet()``` with your new dataset.
For a complete example see sample app
