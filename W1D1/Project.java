// Project Class
// You have been asked by a serial entrepreneur to create a class that she can use to create projects easily. She asks that each project has a name and a description. She needs to be able to create empty projects that she can add a name and description to later; projects with just a name; and projects with both. Every single project should be able to get and set both properties.

// She also needs each project to be able to give an elevator pitch that will return the name and description separated by a colon.

// Of course, you will also need to demo its capabilities for her, so make a ProjectTest class to do this.

// Objectives:
// ● Practice overloading methods such as constructors.

// ● Implement getter and setters.

// Tasks:
// ● Create a Project class that has the fields of name and description.

// ● Create an instance method called elevatorPitch that will return the name and description separated by a colon.

// ● Overload the constructor method in three different ways.

// public Project() {}

// public Project(String name) {}

// public Project(String name, String description) {}

// ● Create getter and setters for each field

// ● Create a ProjectTest file that will test all the functionality.

// Optional Challenges:
// ● Add an additional initialCost member variable that is of type double and has both getters and setters

// ● Add this to the elevator pitch in parentheses after the name, e.g.: name (cost): description

public class Project {

    private String name;
    private String description;
    private Double initialCost;

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    // getter
    public String getDescription() {
        return description;
    }

    // setter
    public void setDescription(String description) {
        this.description = description;
    }

    // getter
    public Double getInitialCost() {
        return initialCost;
    }

    // setter
    public void setInitialCost(Double initialCost) {
        this.initialCost = initialCost;
    }

    // Contructor Overloads

    public Project() {
        this("DJ", "Awesome", 1300.70);
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Project(String name, String description, Double initialCost) {
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }
    

    public void elevatorPitch() {
        System.out.println(this.name + "(" + this.initialCost + ")" + ":" + this.description);
    }
}