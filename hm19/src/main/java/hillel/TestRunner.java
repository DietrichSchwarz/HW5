package edu.hillel;

import edu.hillel.annotations.AfterSuite;
import edu.hillel.annotations.BeforeSuite;
import edu.hillel.annotations.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

  public static void start(Class<?> testClass) throws Exception {
    Method beforeSuiteMethod = null;
    Method afterSuiteMethod = null;
    List<Method> testMethods = new ArrayList<>();
    Object testInstance = testClass.getDeclaredConstructor().newInstance();

    // get methods with annotations
    for (Method method : testClass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(BeforeSuite.class)) {
        if (beforeSuiteMethod == null) {
          beforeSuiteMethod = method;
        } else {
          throw new RuntimeException("BeforeSuite method already exists!");
        }
      } else if (method.isAnnotationPresent(AfterSuite.class)) {
        if (afterSuiteMethod == null) {
          afterSuiteMethod = method;
        } else {
          throw new RuntimeException("AfterSuite method already exists!");
        }
      } else if (method.isAnnotationPresent(Test.class)) {
        testMethods.add(method);
      }
    }

    // sort test methods by priority
    testMethods.sort((m1, m2) -> Integer.compare(m2.getAnnotation(Test.class).priority(),
        m1.getAnnotation(Test.class).priority()));

    // invoke methods
    if (beforeSuiteMethod != null) {
      beforeSuiteMethod.invoke(testInstance);
    }

    for (Method method : testMethods) {
      method.invoke(testInstance);
    }

    if (afterSuiteMethod != null) {
      afterSuiteMethod.invoke(testInstance);
    }
  }
}