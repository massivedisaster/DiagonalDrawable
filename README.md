# DiagonalDrawable

git
<div align="center">
  <img src="art/sample.gif" />
</div>

### Download

Gradle:

```gradle
dependencies {
  implementation 'com.massivedisaster.drawable:diagonaldrawable:0.1.0'
}
```

### Usage

```java
DiagonalDrawable(ContextCompat.getColor(context, R.color.left),
                ContextCompat.getColor(context, R.color.right),
                DiagonalDrawable.Orientation.LEFT_RIGHT)
```

### License
[MIT LICENSE](LICENSE.md)