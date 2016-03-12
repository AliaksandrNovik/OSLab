package OS.rfe.by.novik.virtualmemory;

public class VirtualMemoryPage {
	public int memoryBlock;

	public int notUsedCounter;

	public int accessTime;

	public boolean accessFlag;

	public boolean dirtyFlag;

	public boolean presenseFlag;

	public void read() {
	} // Устанавливает в true accessFlag

	public void resetAccessFlag() {
	} // Сбрасывает флаг accessFlag
}
