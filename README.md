# Computer Graphics in Java

![Java](https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-In%20Progress-f59e0b)

Simple Java implementations of basic computer graphics algorithms for the
**CO2213 Computer Graphics** practicals.

This project is intended for beginners. Each algorithm is kept in a separate
class so that it is easy to read, understand, and improve.

## What is included?

### Line algorithms

- **DDA** - draws a line by calculating small steps between two points.
- **Bresenham** - draws a line using efficient integer calculations.

### Circle algorithms

- **Midpoint Circle** - draws a circle using midpoint decisions.
- **Bresenham Circle** - draws a circle using an incremental error value.

### Transformations

- **Translation** - moves an object.
- **Scaling** - changes the size of an object.
- **Rotation** - turns an object around a point.

## Project structure

```text
computer-graphics-java/
├── line/
│   ├── DDA.java
│   └── Bresenham.java
├── circle/
│   ├── Midpoint.java
│   └── BresenhamCircle.java
├── transformation/
│   ├── Translation.java
│   ├── Scaling.java
│   └── Rotation.java
├── practices/
├── .gitignore
└── README.md
```

The algorithm classes are currently basic scaffolds. They will be completed
step by step as the practical work progresses.

## Requirements

- Java JDK 8 or newer
- Any Java editor or IDE, such as IntelliJ IDEA, Eclipse, or VS Code

Check that Java is installed:

```bash
java -version
javac -version
```

## Getting started

Clone the repository:

```bash
git clone https://github.com/KabileshwaranKabil/computer-graphics-java.git
cd computer-graphics-java
```

Open the project in your preferred Java editor and choose a class to work on.
For example, start with `line/DDA.java`.

## How to work on an algorithm

1. Choose one class from the `line`, `circle`, or `transformation` folder.
2. Read about the algorithm before writing code.
3. Implement one small part at a time.
4. Add a simple example to check the result.
5. Test normal values and edge cases.
6. Keep the code easy for another beginner to understand.

## Contributing

Contributions are welcome, especially improvements that make the algorithms
clearer and easier to learn.

### Contribution steps

1. Fork this repository.
2. Create a new branch:

   ```bash
   git checkout -b add-your-change
   ```

3. Make your changes and try them in your Java editor.
4. Check that your changes work as expected.
5. Commit your work:

   ```bash
   git add .
   git commit -m "Add your change"
   ```

6. Push your branch and open a pull request.

### Contribution guidelines

- Keep each algorithm in its correct package.
- Use clear class, method, and variable names.
- Explain complex logic with short comments where helpful.
- Do not commit `.class` files or build folders.
- Keep changes focused on one improvement at a time.
- Include a short explanation of what you changed.

If you are new to GitHub, you can also open an issue to ask a question or
suggest an improvement.

## Planned improvements

- Complete the line, circle, and transformation algorithms.
- Add simple `main` methods and examples.
- Add automated tests.
- Add a Java2D visualisation.
- Add more notes and practice exercises.

## Academic note

This project is created for learning and practical work in **CO2213 Computer
Graphics**. The main goal is to understand the algorithms, not just to use
ready-made graphics libraries.

## License

No license has been added yet. Until a license is added, all rights are
reserved by the repository owner.
