# Parallel matrix processor

1. Go to source code directory

        cd src/
2. Compile all java files
    
        javac *.java

3. Run the main file with arguments

    - Matrix size 
        - type: integer
        - optional: false
    - Thread count
        - type: integer or percent string
        - optional: true
        - default: all available threads
    - Show response matrix
        - type: bool
        - optional: true
        - default: false
 
    Examples
    
        java Main 4 2 true   // 4x4 matriz - 2 threads - show response matrix
        java Main 4 50% true // 4x4 matriz - 50% of available threads - show response matrix
        java Main 12 4      // 12x12 matriz - 4 threads - not show response matrix