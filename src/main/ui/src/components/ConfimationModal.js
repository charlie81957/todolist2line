import React from 'react';
import Modal from 'react-modal';

const ConfirmationModal = (props) => {
    console.dir()
    var modalFlagInConf = props.modalFlag
    return (
        <Modal isOpen={modalFlagInConf}
          ariaHideApp={false}
        >
        <button>Close Modal</button>
      </Modal>
    )
}

export default ConfirmationModal;