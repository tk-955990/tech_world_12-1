package kadai_12;

import kadai_12.Magician;

public class SuperMagician extends Magician {

	// �����@�U��
	public void super_magic_Attack() {
		System.out.println(this.getName() + "�͒��U�����@�ōU�������I");
		System.out.println("������" + (this.getM_at()) * 2 + "�̃_���[�W��^����");
		setMp(this.getMp() - 20);
		System.out.println("MP���Q�O�|�C���g���" + this.getMp() + "�|�C���g�ɂȂ���");
		// m2.setHp(m2.getHp()-(mg2.getM_at())*2);
	}

}
