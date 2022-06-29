package android.example.notekeeper
// we want a singleton class so declaring it with object instead of class.  one instance to hold all data across fragments
object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes() {
        //TBD
        var note = NoteInfo(CourseInfo("android_intents", "Android Programming with Intents"), "Android Program Notes", "Taking notes about Android Programming")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_core", "Java Fundamentals: The Core Platform"), "Java Core notes", "We be java jammin'")
        notes.add(note)
    }
}