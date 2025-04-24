import java.lang.reflect.Method;

public class DecryptionLab {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("MysteryToolbox");

		Object toolbox = clazz.getDeclaredConstructor().newInstance();

		// List methods
		Method[] methods = clazz.getDeclaredMethods();

		for (Method m : methods) {
			if (m.getParameterCount() == 1 && m.getParameterTypes()[0] == String.class) {
				String methodName = m.getName();
				String key;
				switch (methodName) {
					case "hammer":
						key = "aRTyWEy3RngEqgqq";
						break;
					case "screwdriver":
						key = "kNYWIeNpFYlAOLPK";
						break;
					case "wrench":
						key = "XI4i0C09PZ4rk6fY";
						break;
					case "glue":
						key = "zYeoyfW2agYfeUmi";
						break;
					default:
						key = "";
						break;
				}

				m.setAccessible(true); // not needed here but safe practice
				// Invoke the method to get the decrypted version
				Object result = m.invoke(toolbox, key);
				// Clean the result to remove the repeating
				String cleanResult = result.toString().replaceFirst("🧰 " + methodName + ": ", "");
				System.out.println("🧰 " + methodName + ": " + cleanResult);
			}
		}
		Class<?> studentGadgetClass = Class.forName("StudentGadget");
		Object studentGadget = studentGadgetClass.getDeclaredConstructor().newInstance();
		Method launchMethod = studentGadgetClass.getMethod("launch", String.class);
		String decryptionKey = "U9r1IESzvyqFiLpQ";
		launchMethod.invoke(studentGadget, decryptionKey);
	}
}


