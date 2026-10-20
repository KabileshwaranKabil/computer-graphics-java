## DDA Line Drawing Algorithm

### ⚡ Core Logic & Formulas
* **Differences:** `dx = x2 - x1` and `dy = y2 - y1`
* **Steps:** `steps = Math.max(Math.abs(dx), Math.abs(dy))`
* **Increments:** `xIncrement = (float) dx / steps` & `yIncrement = (float) dy / steps`
* **Next Coordinates:** `x = x + xIncrement` & `y = y + yIncrement`

### 💡 Float vs Int (The Direct Differences)
* **Variables:** `x`, `y`, `xIncrement`, and `yIncrement` **must** be declared as `float`. Using `int` causes integer truncation, dropping fractional movements to `0` and ruining the line slope.
* **Rendering:** Screens don't have fractional pixels. Keep coordinates as `float` internally, but **round** them to the nearest integer when drawing: `g.fillRect(Math.round(x), Math.round(y), 1, 1);`.

### 🧭 Slopes (|m|) Behavior
* **|m| < 1 (Shallow):** `dx > dy` $\rightarrow$ `steps = |dx|`. Axis `x` changes by exactly `1` or `-1`, while `y` changes fractionally (`m`).
* **|m| > 1 (Steep):** `dy > dx` $\rightarrow$ `steps = |dy|`. Axis `y` changes by exactly `1` or `-1`, while `x` changes fractionally (`1/m`).
* **|m| = 1 (Diagonal):** `dx == dy` $\rightarrow$ Both axes change by exactly `1` or `-1`.

### ⚠️ Critical Practical Exam Pitfalls
1. **Integer Division Trap:** Writing `float xInc = dx / steps;` when both are ints performs integer division first. **Fix:** Cast to float explicitly: `(float) dx / steps;`.
2. **Loop Boundary Error:** Use `i <= steps` instead of `i < steps`. A line with 5 steps requires plotting **6 pixels** to include both starting and ending points.
3. **Missing Absolute Values:** Always use `Math.abs(dx)` and `Math.abs(dy)` for steps. Negative values from drawing backward will cause the loop to skip completely.
4. **Division by Zero (Single Point):** If `x1==x2` and `y1==y2`, `steps` is `0`. Floating-point division `0 / 0` yields `NaN`, breaking the loop. **Fix:** Check `if (steps == 0)` to plot one pixel and exit early.
