# CustomDialog-Library
A Simple Custom Alert Dialog with an Image

# Prerequisites

Add this in your root build.gradle file (not your module build.gradle file):
```bash
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
# Dependency  
Add this to your module's build.gradle file (make sure the version matches the JitPack badge above):
```bash
dependencies {
	        implementation 'com.github.yeshwanthmunisifreddy:CustomDialog-Library:1.1.2'
	}
```
# CustomDialog

```bash
CustomAlertDialog.Builder builder = new CustomAlertDialog.Builder(this);
                builder.setTitle("Big Billion Days", 20)
                        .setTitleColor(Color.parseColor("#000000"))
                        .setMessage("Buy any product and get 20% discout up to Rs 5000", 15)
                        .setMessageColor(Color.parseColor("#000000"))
                        .setImage("https://cdn-images-1.medium.com/max/1600/1*j41hMsYft-ifSvXuWOb7Gg.png"
                                , ImageView.ScaleType.FIT_XY)
                        .setCheckBox("Never show", CheckBox.Visible)
                        .setCheckBoxColor(Color.parseColor("#000000"))
                        .setContentCornerRadius(10)
                        .setContentPadding(10)
                        .setIsCancellable(true)
                        .setIcon(R.drawable.close_circle, Icon.Visible, new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), check + "", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setOnAdClickListener(new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Ad is clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
```          
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

