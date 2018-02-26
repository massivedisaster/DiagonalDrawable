# DiagonalDrawable

A Diagonal Drawable for backgrounds, etc.

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

Available orientations:

```java
DiagonalDrawable.Orientation.LEFT_RIGHT
DiagonalDrawable.Orientation.RIGHT_LEFT
```

### License
[MIT LICENSE](LICENSE.md)
